package br.com.fiap.raposymapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.raposymapi.model.ClinicasPublicas;
import br.com.fiap.raposymapi.model.Exercicio;
import br.com.fiap.raposymapi.model.Psicologo;
import br.com.fiap.raposymapi.model.User;
import br.com.fiap.raposymapi.repository.ClinicasPublicasRepository;
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

    @Autowired
    ClinicasPublicasRepository clinicasPublicasRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.save( new User()
                            .name("Gustavo")
                            .email("gustavo@fiap.com")
                            .password(passwordEncoder.encode("123"))
                            //.getRoles().add(new Role("USER"))   
                        );

        userRepository.save( new User()
                            .name("Admin")
                            .email("admin@fiap.com")
                            .password(passwordEncoder.encode("admin"))
                          
                        );

        psicologoRepository.saveAll(List.of( 
            new Psicologo("Fernanda", "Ola, sou a Fernanda e trabalho na Psicologia Viva", 27, 9873, "Privado", "RJ"),
            new Psicologo("Gustavo", "Ola, sou o Gustavo e atualmente trabalho com psicologia", 34, 2434, "Privado", "SP"),
            new Psicologo("Anderson", "Ola, sou o Anderson e estudo psicologia atualmente", 23, 5087, "Público", "BA"),
            new Psicologo("Lucas", "Ola, sou Lucas e sou formado há 30 anos em psicologia", 65, 4093, "Público", "MG"),
            new Psicologo("Michele", "Ola, sou a Michele e trabalho com psicologia há 5 anos", 30, 3409, "Privado", "RS")
            
        ));

        exercicioRepository.saveAll(List.of(
            new Exercicio("Respiração", "Inspire fundo o máximo que conseguir, conte até 10 e expire."),
            new Exercicio("5 sentidos", "Liste 5 coisas que voce vê, 4 coisas que você sente, 3 coisas que você ouve, 2 coisas que você pode sentir o paladar, 1 coisa que você possa cheirar"),
            new Exercicio("Meditação", "Feche os olhos, concentre-se na sua respiração, inspire profundamente e expire lentamente"),
            new Exercicio("Ioga", "Faça a pose Gato/Vaca por 2min, em seguida faça a pose de avião por 3 min")
        ));

        clinicasPublicasRepository.saveAll(List.of(
            new ClinicasPublicas("CLIA", "Rua Vitória Régia, 1095 Santo André - SP", "A CLIA Psicologia, Saúde & Educação em Santo André, oferece uma estrutura que atende às considerações acima.", 
            "(11) 4002-8922"),

            new ClinicasPublicas("Mancini Psiquiatria e Psicologia", "Alameda Joaquim Eugênio de Lima, 187", "Equipe com os melhores especialistas e pesquisadores em Saúde Mental da USP, selecionados pelo Dr. Renato Mancini.", 
            "(11) 8922-2004"),

            new ClinicasPublicas("Psicologia para a Vida", "Rua das Caneleiras, 488 - Bairro Jardim, Santo André.", "Somos uma clínica focada em ajudar você a se reconectar consigo por meio da psicoterapia e de uma equipe multidisciplinar.", 
            "(11) 98743-0000")

        ));
    }
    
}
