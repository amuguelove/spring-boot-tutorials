package com.flygopher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.UUID;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveMongoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReactiveMongoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        coffeeRepository
                .deleteAll()
                .thenMany(
                        Flux.just("latte", "capuccino", "mocha", "latte1")
                                .map(name -> new Coffee(UUID.randomUUID().toString(), name))
                                .flatMap(coffeeRepository::save)
                )
                .thenMany(coffeeRepository.findByName("latte"))
                .subscribe(coffee -> System.out.println("get " + coffee.toString()));
    }
}
