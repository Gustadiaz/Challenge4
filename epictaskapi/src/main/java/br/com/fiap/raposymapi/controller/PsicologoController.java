package br.com.fiap.raposymapi.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.fiap.raposymapi.model.Psicologo;
import br.com.fiap.raposymapi.service.PsicologoService;

@RestController
@RequestMapping("/api/psicologo")
public class PsicologoController {

    @Autowired
    private PsicologoService service;
    
    @GetMapping
    public Page<Psicologo> index(@PageableDefault(size = 1000) Pageable paginacao){
        return service.listAll(paginacao);
    }

    @PostMapping
    public ResponseEntity<Psicologo> create(@RequestBody @Valid Psicologo psicologo){
        service.save(psicologo);
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(psicologo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Psicologo> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Psicologo> update(@PathVariable Long id, @RequestBody @Valid Psicologo newPsicologo){
        var optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var psicologo = optional.get();
        BeanUtils.copyProperties(newPsicologo, psicologo);
        psicologo.setId(id);

        service.save(psicologo);
        return ResponseEntity.ok(psicologo);
    }




}
