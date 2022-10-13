package br.com.fiap.raposymapi.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.raposymapi.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

    Page<Exercicio> findAll(Pageable pageable);
    
}
