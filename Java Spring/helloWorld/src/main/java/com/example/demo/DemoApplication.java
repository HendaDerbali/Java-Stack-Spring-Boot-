package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//// 1. Annotation
//@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	   // 1. Annotation
//	@RequestMapping("/")
//    // 3. Method that maps to the request route above
//    public String index() { // 3
//            return "Hello World";
//    }

}
