package br.com.fiap.raposymapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.raposymapi.model.Exercicio;
import br.com.fiap.raposymapi.model.Psicologo;
import br.com.fiap.raposymapi.model.User;
import br.com.fiap.raposymapi.repository.ExercicioRepository;
import br.com.fiap.raposymapi.repository.PsicologoRepository;
import br.com.fiap.raposymapi.repository.UserRepository;

@Configuration
@Profile("dev")
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    PsicologoRepository psicologoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ExercicioRepository exercicioRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.save( new User()
                            .name("Gustavo")
                            .email("gustavo@fiap.com")
                            .password(passwordEncoder.encode("123"))
                            //.getRoles().add(new Role("USER"))   
                        );

        psicologoRepository.saveAll(List.of( 
            new Psicologo("Fernada", "Ola, sou a Fernanda e trabalho na Psicologia Viva", 27, 9873, "Privado"),
            new Psicologo("Gustavo", "Ola, sou a Fernanda e atualmente trabalho com psicologia", 34, 2434, "Privado")
            
        ));

        exercicioRepository.saveAll(List.of(
            new Exercicio("Respiração", "Inspire fundo o máximo que conseguir, conte até 10 e expire.")
        ));
    }
    
}
