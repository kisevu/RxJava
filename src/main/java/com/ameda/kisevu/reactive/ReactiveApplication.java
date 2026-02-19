package com.ameda.kisevu.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ReactiveApplication.class, args);
//		System.out.println(" No of cores "+ Runtime.getRuntime().availableProcessors());
	}

}
