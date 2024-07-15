package com.reactive.user.repository;

import com.reactive.user.entity.Trunk;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TrunkRepository extends ReactiveCrudRepository<Trunk, String> {
}
