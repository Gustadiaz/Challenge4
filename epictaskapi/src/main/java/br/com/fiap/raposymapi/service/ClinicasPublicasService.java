package br.com.fiap.raposymapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.fiap.raposymapi.model.ClinicasPublicas;
import br.com.fiap.raposymapi.repository.ClinicasPublicasRepository;

import org.springframework.data.domain.Pageable;

@Service
public class ClinicasPublicasService {
    
    @Autowired
    private ClinicasPublicasRepository repository;


    public Page<ClinicasPublicas> listAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public ClinicasPublicas save(ClinicasPublicas clinicaspublicas){
        return repository.save(clinicaspublicas);
    }

    public Optional<ClinicasPublicas> get(Long id) {
        return repository.findById(id);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

  

}