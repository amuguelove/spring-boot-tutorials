package com.flygopher;

import com.flygopher.support.MoneyReadConverter;
import com.flygopher.support.MoneyWriteConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.Arrays;
import java.util.TimeZone;

@SpringBootApplication
@EnableR2dbcRepositories
public class WebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}

	@Bean
	public R2dbcCustomConversions r2dbcCustomConversions() {
		return new R2dbcCustomConversions(Arrays.asList(new MoneyReadConverter(), new MoneyWriteConverter()));
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
		return builder -> builder.indentOutput(true)
				.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
	}
}
