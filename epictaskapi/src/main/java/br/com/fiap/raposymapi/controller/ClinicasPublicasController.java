package br.com.fiap.raposymapi.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.raposymapi.model.ClinicasPublicas;
import br.com.fiap.raposymapi.service.ClinicasPublicasService;

@RestController
@RequestMapping("/api/clinicaspublicas")
public class ClinicasPublicasController {
    
    @Autowired
    private ClinicasPublicasService service;

    @GetMapping
    @Cacheable("clinicaspublicas")
    public Page<ClinicasPublicas> index(@PageableDefault(size = 5) Pageable pageable){
        return service.listAll(pageable);
    }

    @PostMapping
    @CacheEvict(value = "clinicaspublicas", allEntries = true)
    public ResponseEntity<ClinicasPublicas> create(@RequestBody @Valid ClinicasPublicas clinicaspublicas){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clinicaspublicas));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClinicasPublicas> show(@PathVariable Long id){
        return ResponseEntity.of(service.get(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "clinicaspublicas", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<ClinicasPublicas> optional = service.get(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    @CacheEvict(value = "clinicaspublicas", allEntries = true)
    public ResponseEntity<ClinicasPublicas> update(@PathVariable Long id, @RequestBody @Valid ClinicasPublicas newClinicasPublicas){
        Optional<ClinicasPublicas> optional = service.get(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var clinicaspublicas = optional.get();
        BeanUtils.copyProperties(newClinicasPublicas, clinicaspublicas);
        clinicaspublicas.setId(id);
        service.save(clinicaspublicas);

        return ResponseEntity.ok(clinicaspublicas);
    }

}
