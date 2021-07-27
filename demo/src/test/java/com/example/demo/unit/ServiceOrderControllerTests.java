package com.example.demo.unit;

import com.example.entity.CollectionPost;
import com.example.entity.Doctor;
import com.example.entity.Exam;
import com.example.entity.Patient;
import com.example.entity.ServiceOrder;
import com.example.repository.CollectionPostRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.ExamRepository;
import com.example.repository.PatientRepository;
import com.example.repository.ServiceOrderExamRepository;
import com.example.repository.ServiceOrderRepository;
import com.example.rest.ServiceOrderController;
import com.example.services.ServiceOrderService;
import com.example.vo.ServiceOrderVO;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;



import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ServiceOrderController.class)
public class ServiceOrderControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    ServiceOrderRepository serviceOrderRepository;
    @MockBean
    DoctorRepository doctorRepository;
    @MockBean
    PatientRepository patientRepository;
    @MockBean
    CollectionPostRepository collectionPostRepository;
    @MockBean
    ExamRepository examRepository;
    @MockBean
    ServiceOrderExamRepository serviceOrderExamRepository;
    @MockBean
    ServiceOrderService serviceOrderService;
    
    @Test
    public void testGetListDoctors() throws  Exception{
        List<Doctor> doctorsMock = new ArrayList<>();
        Doctor m1 = new Doctor("Doctor 1", "ESPECIALIDADE 1");
        m1.setId(1);
        Doctor m2 = new Doctor("Doctor 2", "ESPECIALIDADE 2");
        m2.setId(2);
        doctorsMock.add(m1);
        doctorsMock.add(m2);

        Mockito.when(doctorRepository.findAll()).thenReturn(doctorsMock);

        mockMvc.perform(
            MockMvcRequestBuilders
            .get("/serviceOrder/list_doctors")
            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetListPosts() throws  Exception{
        List<CollectionPost> postsMock = new ArrayList<>();
        CollectionPost p1 = new CollectionPost("POSTO 1", "ENDEREÇO");
        p1.setId(1);
        CollectionPost p2 = new CollectionPost("POSTO 2", "ENDERECO 2");
        p2.setId(2);
        postsMock.add(p1);
        postsMock.add(p2);

        Mockito.when(collectionPostRepository.findAll()).thenReturn(postsMock);

        mockMvc.perform(
            MockMvcRequestBuilders
            .get("/serviceOrder/list_posts")
            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }
    @Test
    public void testGetListExams() throws  Exception{
        List<Exam> examesMock = new ArrayList<>();
        Exam e1 = new Exam("EXAME 1", 100.00);
        e1.setId(1);
        Exam e2 = new Exam("EXAME 2", 100.00);
        e2.setId(2);
        examesMock.add(e1);
        examesMock.add(e2);

        Mockito.when(examRepository.findAll()).thenReturn(examesMock);

        mockMvc.perform(
            MockMvcRequestBuilders
            .get("/serviceOrder/list_exams")
            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testGetListPatients() throws  Exception{
        List<Patient> patientsMock = new ArrayList<>();
        Patient p1 = new Patient("PACIENTE 1", "MASCULINO", "ENDEREÇO 1", new Date() );
        p1.setId(1);
        Patient p2 = new Patient("PACIENTE 2", "MASCULINO", "ENDEREÇO 2", new Date() );
        p2.setId(2);
        patientsMock.add(p1);
        patientsMock.add(p2);

        Mockito.when(patientRepository.findAll()).thenReturn(patientsMock);

        mockMvc.perform(
            MockMvcRequestBuilders
            .get("/serviceOrder/list_patients")
            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testPostSave_empty_badRequest() throws Exception{
        ServiceOrderVO os = new ServiceOrderVO();
        mapper.setSerializationInclusion(Include.NON_NULL);
        Mockito.when(serviceOrderService.Save(Mockito.any(ServiceOrderVO.class))).thenThrow(new Exception());
        String json = "";
        try{
            json = this.mapper.writeValueAsString(os);
        }catch(Exception ex){
            json = "";
        }
        RequestBuilder request = MockMvcRequestBuilders
        .post("/serviceOrder/save")
        .accept(MediaType.APPLICATION_JSON)
        .content(json)
        .contentType(MediaType.APPLICATION_JSON);
        System.out.println("JSON ENTRADA: " + json);
        mockMvc.perform(request)
        .andExpect(status().isBadRequest());
        
    }

    @Test
    public void testPostSave_created() throws Exception{
        List<Integer> exams = new ArrayList<>();
        exams.add(1);
        exams.add(2);
        ServiceOrderVO os = new ServiceOrderVO();
        os.setHealthInsurance("CONVENIO");
        os.setDate(new Date());
        os.setExams(exams);
        os.setDoctorId(1);
        os.setPatientId(1);
        os.setPostId(1);
        os.setPrice(100.00);
        Mockito.when(serviceOrderService.Save(Mockito.any(ServiceOrderVO.class))).thenReturn(new ServiceOrder());

        RequestBuilder request = MockMvcRequestBuilders
        .post("/serviceOrder/save")
        .accept(MediaType.APPLICATION_JSON)
        .content(this.mapper.writeValueAsString(os))
        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
        .andExpect(status().isOk());
    }

    @Test
    public void testDelete_success() throws Exception{
        Doctor doc = new Doctor("MEDICO", "ESPECIALIDADE");
        doc.setId(1);
        Patient patient = new Patient("NOME", "MASCULINO", "ENDEREÇO", new Date());
        patient.setId(1);
        CollectionPost collectionPost = new CollectionPost("NOME", "ENDEREÇO");
        collectionPost.setId(1);
        Mockito.when(doctorRepository.findById(1)).thenReturn(Optional.of(doc));
        Mockito.when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        Mockito.when(collectionPostRepository.findById(1)).thenReturn(Optional.of(collectionPost));
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setHealthInsurance("HBSAUDE");
        serviceOrder.setDate(new Date());
        serviceOrder.setDoctor(doctorRepository.getById(1));
        serviceOrder.setPatient(patientRepository.getById(1));
        serviceOrder.setCollectionPost(collectionPostRepository.getById(1));
        serviceOrder.setId(1);
        ServiceOrderVO os = new ServiceOrderVO();
        Mockito.when(serviceOrderRepository.findById(1)).thenReturn( Optional.of(serviceOrder));
        serviceOrder = serviceOrderRepository.findById(1).get();
        os.setId(serviceOrder.getId());
        Mockito.when(serviceOrderService.Remove(os)).thenReturn(true);
        

        
        RequestBuilder request = MockMvcRequestBuilders
        .post("/serviceOrder/delete")
        .accept(MediaType.APPLICATION_JSON)
        .content(this.mapper.writeValueAsString(os))
        .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
        .andExpect(status().isOk());
    }
}