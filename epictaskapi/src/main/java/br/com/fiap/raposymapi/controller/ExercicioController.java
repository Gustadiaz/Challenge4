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

import br.com.fiap.raposymapi.model.Exercicio;
import br.com.fiap.raposymapi.service.ExercicioService;

@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {
    
    @Autowired
    private ExercicioService service;

    @GetMapping
    @Cacheable("exercicio")
    public Page<Exercicio> index(@PageableDefault(size = 1000) Pageable pageable){
        return service.listAll(pageable);
    }

    @PostMapping
    @CacheEvict(value = "exercicio", allEntries = true)
    public ResponseEntity<Exercicio> create(@RequestBody @Valid Exercicio exercicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(exercicio));
    }

    @GetMapping("{id}")
    public ResponseEntity<Exercicio> show(@PathVariable Long id){
        return ResponseEntity.of(service.get(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "exercicio", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<Exercicio> optional = service.get(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    @CacheEvict(value = "exercicio", allEntries = true)
    public ResponseEntity<Exercicio> update(@PathVariable Long id, @RequestBody @Valid Exercicio newExercicio){
        Optional<Exercicio> optional = service.get(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var exercicio = optional.get();
        BeanUtils.copyProperties(newExercicio, exercicio);
        exercicio.setId(id);
        service.save(exercicio);

        return ResponseEntity.ok(exercicio);
    }

}

