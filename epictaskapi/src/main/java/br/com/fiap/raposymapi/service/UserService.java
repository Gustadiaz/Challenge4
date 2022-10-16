package br.com.fiap.raposymapi.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.raposymapi.model.User;
import br.com.fiap.raposymapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    

    public Page<User> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void save(@Valid User user) {
        user.setPassword(user.getPassword());
        repository.save(user);
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public void update(User user) {
        repository.save(user);
    }
    
}
