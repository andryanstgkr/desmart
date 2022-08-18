package com.andryanstgkr.desmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class} , scanBasePackages = { "com.andryanstgkr.desmart.controller",  "com.andryanstgkr.desmart.service", "com.andryanstgkr.desmart.repository", "com.andryanstgkr.desmart.config", "com.andryanstgkr.desmart.model"})

//next NoUniqueBeanDefinitionException, to exclude BaseController or to move to other package
@EnableJpaRepositories(basePackages = { "com.andryanstgkr.desmart.repository" })
@EnableJpaAuditing
@EnableTransactionManagement
public class DesmartApplication{

	public static void main(String[] args) {
		SpringApplication.run(DesmartApplication.class, args);
	}
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}*/
}
