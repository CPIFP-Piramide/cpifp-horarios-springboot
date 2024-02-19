package com.cpifppiramide.aulas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AulasApplication {

	public static void main(String[] args) {
		try (var connection =  DB.connect()){
			System.out.println("Connected to the PostgreSQL database.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		SpringApplication.run(AulasApplication.class, args);
	}

}
