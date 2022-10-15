package br.com.fiap.raposymapi.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.raposymapi.model.ClinicasPublicas;

public interface ClinicasPublicasRepository extends JpaRepository<ClinicasPublicas, Long>{

    Page<ClinicasPublicas> findAll(Pageable pageable);
    
}