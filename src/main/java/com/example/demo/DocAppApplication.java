package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.doc.controller","com.doc.service","com.doc.config"})
@EntityScan("com.doc.entity")
@EnableJpaRepositories("com.doc.dao")
//@EnableSwagger2
public class DocAppApplication {

	public static void main(String[] args) {
 		SpringApplication.run(DocAppApplication.class, args);
	}
}
