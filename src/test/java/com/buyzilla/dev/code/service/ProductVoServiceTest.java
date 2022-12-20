package com.buyzilla.dev.code.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = BuyZillaApplication.class)
@Testcontainers
@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
        "spring.datasource.url=jdbc:tc:postgresql:12//springboot"
})
//@SpringBootTest(classes = BuyZillaApplication.class)
//@SpringBootTest(classes = {
//        BuyZillaApplication.class,
//        ProductService.class
//})
public class ProductVoServiceTest {

    @Autowired
    ProductService productService;

/*    @BeforeAll
    static void init(){
        System.out.println("I am before all");
        System.out.println("Initializing");
    }*/

/*    @Test
    @Sql("/scripts/test.sql")
    public void findAllTest(){
        assertEquals(200,productService.getProducts().getStatusCodeValue());
    }*/

}
