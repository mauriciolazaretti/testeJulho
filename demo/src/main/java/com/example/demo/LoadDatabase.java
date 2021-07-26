package com.example.demo;

import com.example.entity.Exam;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.CollectionPost;
import com.example.repository.CollectionPostRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.ExamRepository;
import com.example.repository.PatientRepository;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PatientRepository repository, ExamRepository examRepository, DoctorRepository medicoRepositorio, CollectionPostRepository postoRepositorio) {

    return args -> {
        try{
      
      if(medicoRepositorio.findAll().size() == 0){
      SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
      CollectionPost posto1 = new CollectionPost("POSTO 1", "RUA DOS TESTES");
      CollectionPost posto2 = new CollectionPost("POSTO 2", "RUA DOS TESTES");
      postoRepositorio.save(posto1);
      postoRepositorio.save(posto2);
      
      Doctor m1 = new Doctor("Medico Joãozinho", "OFTAMOLOGISTA");
      Doctor m2 = new Doctor("Medico Zézinho", "OBSTRETA");
      medicoRepositorio.save(m1);
      medicoRepositorio.save(m2);
      Exam ex1 = new Exam("Exam 1", 80.00);
      Exam ex2 = new Exam("Exam 2", 100.00);

      examRepository.save(ex1);
      examRepository.save(ex2);

      Patient c1 = new Patient("TESTE 1", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1994"));
      Patient c2 = new Patient("TESTE 2", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1995"));
      Patient c3 = new Patient("TESTE 3", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1996"));
      repository.save(c1);
      repository.save(c2);
      repository.save(c3);
      }

      log.info("SALVOU");
        }catch(Exception ex){
            log.error(ex.getMessage());
        }
    };
  }
}