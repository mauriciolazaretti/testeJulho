package com.example.services;

import com.example.entity.Exam;
import com.example.entity.Doctor;
import com.example.entity.ServiceOrder;
import com.example.entity.ServiceOrderExam;
import com.example.entity.Patient;
import com.example.entity.CollectionPost;
import com.example.repository.ExamRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.ServiceOrderRepository;
import com.example.repository.PatientRepository;
import com.example.repository.CollectionPostRepository;
import com.example.vo.ServiceOrderVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceOrderService implements Serializable  {
    
    /**
     *
     */
    
    /**
     *
     */
    private static final long serialVersionUID = 5108105748535290136L;
    /**
     *
     */
    /**
     *
     */
    
    @Autowired
    private ServiceOrderRepository serviceOrderRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private CollectionPostRepository collectionPostRepository;
    @Autowired
    private ExamRepository examRepository;
    public List<ServiceOrder> List(){
        return serviceOrderRepository.findAll();
    }
    public Boolean Remove(ServiceOrderVO ordem){
        try{
        if(ordem.getId() == null)
            return false;
        ServiceOrder ordemServico = serviceOrderRepository.getById(ordem.getId());
        
        serviceOrderRepository.delete(ordemServico);
        return true;
        }catch(Exception ex){
            return false;
        }
    }

    private ServiceOrder FetchOrCreateInstance(Integer id){
        if(id == null)
            return new ServiceOrder();
        return serviceOrderRepository.getById(id);
    }


    private ServiceOrder FillObject(ServiceOrderVO ordemServicoVO, ServiceOrder serviceOrder){
        List<ServiceOrderExam> listOrderExams = new ArrayList<>();
        List<Exam> listExams = examRepository.findAllById(ordemServicoVO.getExams());
        for(Exam ex : listExams){

            listOrderExams.add(new ServiceOrderExam(ex, serviceOrder, ex.getPrice() ));
        }

        CollectionPost post = collectionPostRepository.getById(ordemServicoVO.getPostId());
        Patient patient = patientRepository.getById(ordemServicoVO.getPatientId());
        Doctor medico = doctorRepository.getById(ordemServicoVO.getDoctorId());
        serviceOrder.setHealthInsurance(ordemServicoVO.getHealthInsurance());
        serviceOrder.setDate(ordemServicoVO.getDate());
        serviceOrder.setCollectionPost(post);
        serviceOrder.setPatient(patient);
        serviceOrder.setDoctor(medico);
        if(ordemServicoVO.getId() != null){
            
            serviceOrder.getServiceOrderExams().clear();
            serviceOrder.getServiceOrderExams().addAll(listOrderExams);
        }else{
            serviceOrder.setServiceOrderExams(listOrderExams);
        }
        return serviceOrder;
       
    }

    private String ValidateData(ServiceOrderVO ordemServicoVO){
        if(ordemServicoVO.getDoctorId() == null)
            return "Médico inválido";
        if(ordemServicoVO.getPatientId() == null)
            return "Paciente inválido";
        if(ordemServicoVO.getPostId() == null)
            return "Posto de coleta inválido";
        return null;
    }

    public ServiceOrder Save(ServiceOrderVO serviceOrderVO) throws Exception {
        if(serviceOrderVO == null)
            return null;

        String validationMsg = this.ValidateData(serviceOrderVO);
        if(validationMsg != null)
            throw new Exception(validationMsg);
        
        ServiceOrder ordemServico = this.FetchOrCreateInstance(serviceOrderVO.getId());

        ordemServico = this.FillObject(serviceOrderVO, ordemServico);
        
        serviceOrderRepository.save(ordemServico);   
        return ordemServico;
    }





}