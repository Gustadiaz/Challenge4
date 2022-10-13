package br.com.fiap.raposymapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.fiap.raposymapi.model.Exercicio;
import br.com.fiap.raposymapi.repository.ExercicioRepository;

import org.springframework.data.domain.Pageable;

@Service
public class ExercicioService {
    
    @Autowired
    private ExercicioRepository repository;


    public Page<Exercicio> listAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Exercicio save(Exercicio exercicio){
        return repository.save(exercicio);
    }

    public Optional<Exercicio> get(Long id) {
        return repository.findById(id);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

  

}
