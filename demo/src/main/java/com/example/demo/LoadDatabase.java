package com.example.demo;

import com.example.entity.Exame;
import com.example.entity.Medico;
import com.example.entity.Paciente;
import com.example.entity.PostoColeta;
import com.example.repositorio.ExameRepositorio;
import com.example.repositorio.MedicoRepositorio;
import com.example.repositorio.PacienteRepositorio;
import com.example.repositorio.PostoColetaRepositorio;
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
  CommandLineRunner initDatabase(PacienteRepositorio repository, ExameRepositorio exameRepositorio, MedicoRepositorio medicoRepositorio, PostoColetaRepositorio postoRepositorio) {

    return args -> {
        try{
      
      if(medicoRepositorio.findAll().size() == 0){
      SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
      PostoColeta posto1 = new PostoColeta("POSTO 1", "RUA DOS TESTES");
      PostoColeta posto2 = new PostoColeta("POSTO 2", "RUA DOS TESTES");
      postoRepositorio.save(posto1);
      postoRepositorio.save(posto2);
      
      Medico m1 = new Medico("Medico Joãozinho", "OFTAMOLOGISTA");
      Medico m2 = new Medico("Medico Zézinho", "OBSTRETA");
      medicoRepositorio.save(m1);
      medicoRepositorio.save(m2);
      Exame ex1 = new Exame("EXAME 1", 80.00);
      Exame ex2 = new Exame("EXAME 2", 100.00);

      exameRepositorio.save(ex1);
      exameRepositorio.save(ex2);

      Paciente c1 = new Paciente("TESTE 1", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1994"));
      Paciente c2 = new Paciente("TESTE 2", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1995"));
      Paciente c3 = new Paciente("TESTE 3", "MASCULINO", "RUA DOS TESTES", fmt.parse("08/04/1996"));
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