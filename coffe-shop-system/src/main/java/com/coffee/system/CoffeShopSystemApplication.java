package com.coffee.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeShopSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeShopSystemApplication.class, args);
		
//		 Reflections reflections = new Reflections("com.coffee.system", new SubTypesScanner(false));
//		     reflections.getSubTypesOf(Object.class)
//		      .stream()
//		      .collect(Collectors.toSet())
//		      .forEach(s->System.out.println(">>>>>>> LOG:"+s));
//		     
		
	}

}

