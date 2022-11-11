package com.example.ecom.demo;

import com.example.ecom.demo.utils.ProductsUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomdemoApplication {

	public static void main(String[] args) {
		ProductsUtil.init();
		SpringApplication.run(EcomdemoApplication.class, args);
	}

}
