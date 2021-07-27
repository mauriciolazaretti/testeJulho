package com.example.rest;

import com.example.entity.ServiceOrder;
import com.example.services.CollectionPostService;
import com.example.services.ExamService;
import com.example.services.DoctorService;
import com.example.services.PatientService;
import com.example.services.ServiceOrderService;
import com.example.vo.ServiceOrderVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("serviceOrder")
@CrossOrigin(origins="*")
public class ServiceOrderController {
    @Autowired
    private ServiceOrderService serviceOrderService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private CollectionPostService collectionPostService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private ExamService examService;

    @PostMapping("/delete")
    ResponseEntity delete(@RequestBody ServiceOrderVO serviceOrderVO){
        try{
            serviceOrderService.Remove(serviceOrderVO);
            return new ResponseEntity("", HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    ResponseEntity list(){
        return new ResponseEntity(serviceOrderService.List(), HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity save(@RequestBody ServiceOrderVO serviceOrderVO){
        try{
        ServiceOrder order = serviceOrderService.Save(serviceOrderVO);
        return new ResponseEntity(order, HttpStatus.OK);
        }catch(Exception ex){
            return new  ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list_doctors")
    ResponseEntity listDoctors(){
        return new ResponseEntity(doctorService.List(), HttpStatus.OK);
    }

    @GetMapping("/list_patients")
    ResponseEntity listPatients(){
        return new ResponseEntity(patientService.List(), HttpStatus.OK);
    }

    @GetMapping("/list_posts")
    ResponseEntity listCollectionPosts(){
        return new ResponseEntity(collectionPostService.List(), HttpStatus.OK);
    }

    @GetMapping("/list_exams")
    ResponseEntity listExams(){
        return new ResponseEntity(examService.List(), HttpStatus.OK);
    }
}
