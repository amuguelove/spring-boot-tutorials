package com.flygopher;

import com.flygopher.converter.MoneyReadConverter;
import com.flygopher.converter.MoneyWriteConverter;
import com.flygopher.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Slf4j
@EnableR2dbcRepositories
public class R2dbcDemoApplication implements ApplicationRunner {

	@Autowired
	private CoffeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(R2dbcDemoApplication.class, args);
	}

	@Bean
	public R2dbcCustomConversions r2dbcCustomConversions() {
		return new R2dbcCustomConversions(Arrays.asList(new MoneyReadConverter(), new MoneyWriteConverter()));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(2);

		repository.findAllById(Flux.just(1L, 2L))
				.map(c -> c.getName() + "-" + c.getPrice().toString())
				.doFinally(s -> cdl.countDown())
				.subscribe(c -> log.info("Find {}", c));

		repository.findByName("mocha")
				.doFinally(s -> cdl.countDown())
				.subscribe(c -> log.info("Find {}", c));

		cdl.await();
	}
}
