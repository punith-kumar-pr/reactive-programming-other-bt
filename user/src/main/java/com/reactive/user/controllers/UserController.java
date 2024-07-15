package com.reactive.user.controllers;

import com.reactive.user.entity.User;
import com.reactive.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    private UserService userService;

    // add user
    @PostMapping
    public Mono<User> add(@RequestBody User body) {
        return userService.add(body);
    }

    // get all users
    @GetMapping
    public Flux<User> getAll() {
                return userService.getAll();
    }

    // get one user
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    // update user
    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable int id, @RequestBody User body) {
        return userService.update(id, body);
    }

    // delete user
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return userService.delete(id);
    }

}
