package br.com.fiap.raposymapi.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.raposymapi.model.Psicologo;
import br.com.fiap.raposymapi.repository.PsicologoRepository;

@Service
public class PsicologoService {
    
    @Autowired
    PsicologoRepository repository;

    public Page<Psicologo> listAll(Pageable paginacao){
        return repository.findAll(paginacao);
    }

    public void save(Psicologo psicologo) {
        repository.save(psicologo);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Optional<Psicologo> getById(Long id) {
        return repository.findById(id);
    }

}
