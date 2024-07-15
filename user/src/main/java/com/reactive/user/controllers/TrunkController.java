package com.reactive.user.controllers;

import com.reactive.user.entity.Trunk;
import com.reactive.user.repository.TrunkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trunk")
public class TrunkController {

    @Autowired
    private TrunkRepository trunkRepository;

    @PostMapping
    public Mono<Trunk> save (@RequestBody Trunk body) {
        return trunkRepository.save(body);
    }
}
