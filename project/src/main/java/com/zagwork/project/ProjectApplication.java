package com.zagwork.project;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class ProjectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}

interface ClienteRepository extends ReactiveMongoRepository<Cliente, Long>{
}

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
class Cliente {
	private Long id;
	private String cliente;
	private BigDecimal credito;
	private String risco;
	private BigDecimal txJuros;
}

