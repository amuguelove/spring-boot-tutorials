package com.flygopher;

import com.flygopher.common.BaseJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class)
public class QuerydslDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslDemoApplication.class, args);
    }

}
