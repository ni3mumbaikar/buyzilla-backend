package com.example.ecom.demo;

import com.example.ecom.demo.utils.ProductUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EcomdemoApplication {

	public static void main(String[] args) throws IOException {
		ProductUtils.init();
		SpringApplication.run(EcomdemoApplication.class, args);
	}

}
