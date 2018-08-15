package com.devjava.aluno;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeiroSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroSpringBootApplication.class, args);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("<<< Projeto Primeiro Spring Boot está rodando agora... >>>");
		System.out.println("às " + sdf.format(calendar.getTime()));
	}
}
