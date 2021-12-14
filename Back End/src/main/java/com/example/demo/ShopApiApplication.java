package com.example.demo;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ShopApiApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(ShopApiApplication.class, args);
		
	}

}
