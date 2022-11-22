package com.example.ecom.demo.service;

import com.example.ecom.demo.EcomDemoApplication;
import com.example.ecom.demo.respository.ProductRepository;
import com.example.ecom.demo.service.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = EcomDemoApplication.class)
@Testcontainers
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
        "spring.datasource.url=jdbc:tc:postgresql:12//springboot"
})
//@SpringBootTest(classes = EcomDemoApplication.class)
//@SpringBootTest(classes = {
//        EcomDemoApplication.class,
//        ProductService.class
//})
public class ProductServiceTest {

    @Autowired
    ProductService productService;

/*    @BeforeAll
    static void init(){
        System.out.println("I am before all");
        System.out.println("Initializing");
    }*/

    @Test
    @Sql("/scripts/test.sql")
    public void findAllTest(){
        assertEquals(200,productService.getProducts().getStatusCodeValue());
    }

}
