package com.reactive.user.services;

import com.reactive.user.entity.User;
import com.reactive.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Mono<User> getById(int id){
        return userRepository.findById( id);
    }

    public Mono<Void> delete(int id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> update(int id, User body) {
        Mono<User> oldUser = userRepository.findById(id);
        return oldUser.flatMap(newBook -> {
            if (body.getName() != null)
            newBook.setName(body.getName());
            if (body.getEmail() != null)
            newBook.setEmail(body.getEmail());
            if (body.getAddress() != null)
            newBook.setAddress(body.getAddress());
            return userRepository.save(newBook);
        });
    }

    public Mono<User> add(User body) {
        return userRepository.save(body);
    }



}
