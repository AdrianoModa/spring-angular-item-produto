package com.devjava.aluno;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrimeiroSpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroSpringBootApplication.class, args);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy", new Locale("pt", "BR"));
		Calendar calendar = Calendar.getInstance();
		System.out.println("Projeto Primeiro Spring Boot está rodando agora... às " + sdf.format(calendar.getTime()));
	}
}
