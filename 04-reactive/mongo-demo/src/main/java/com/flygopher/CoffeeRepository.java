package com.flygopher;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CoffeeRepository extends ReactiveMongoRepository<Coffee, String> {

    Flux<Coffee> findByName(String name);

}


