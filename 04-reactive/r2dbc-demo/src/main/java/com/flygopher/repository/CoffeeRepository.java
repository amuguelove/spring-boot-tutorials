package com.flygopher.repository;

import com.flygopher.model.Coffee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CoffeeRepository extends ReactiveCrudRepository<Coffee, Long> {

    @Query("select * from t_coffee where name = :name")
    Flux<Coffee> findByName(String name);
}
