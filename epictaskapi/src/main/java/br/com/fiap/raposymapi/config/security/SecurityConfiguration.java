package br.com.fiap.raposymapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration{

    // Security Filter Chain - autorização
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.httpBasic()
            .and()
            .authorizeHttpRequests()
                // Psicólogos
                .antMatchers(HttpMethod.GET, "/api/psicologo/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/psicologo").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/psicologo/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/psicologo/**").authenticated()
                
                // Usuário
                .antMatchers(HttpMethod.GET, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/user/**").authenticated()

                //Exercicio
                .antMatchers(HttpMethod.GET, "/api/exercicio/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/exercicio").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/exercicio/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/exercicio/**").authenticated()

                //Clinicas
                .antMatchers(HttpMethod.GET, "/api/clinicaspublicas/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/clinicaspublicas").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/clinicaspublicas/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/clinicaspublicas/**").authenticated()

                // Infra
                .antMatchers("/h2-console/**").permitAll()
                
                .anyRequest().denyAll()
            .and()
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                
        ;

        return http.build();
    }


    // UserDetailsService - autenticação
    // @Bean
    // public UserDetailsService users(){
    //     UserDetails user = User.builder()
    //         .username("joao@fiap.com.br")
    //         .password("$2a$12$Q6XvAE/wN7oS2GCURWj0T.243UaVK6./zRwQdqBoAW7pCW4lv4YVi")
    //         .roles("USER")
    //     .build();

    //     return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
}
