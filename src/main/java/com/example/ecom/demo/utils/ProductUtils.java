package com.example.ecom.demo.utils;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.exceptions.ProductNotFoundException;
import com.example.ecom.demo.exceptions.ResourceAlreadyExistException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductUtils {

    static ObjectMapper objectMapper = new ObjectMapper();
    static String dbPath = "C:\\Users\\10708461\\Documents\\myDB\\json-work\\db.json";

    private static List<Product> productsList;

    public static void init() throws IOException {
        // get List of Products from json file
        productsList = new ArrayList<>(Arrays.asList(objectMapper.readValue(Paths.get(dbPath).toFile(), Product[].class)));
    }

    public static Product getProductByPid(Integer pid) throws ProductNotFoundException {
        try {
            return productsList.stream().filter(product -> pid == product.getProductID()).toList().get(0);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new ProductNotFoundException(pid);
        }
    }

    public static List<Product> getProductsList() {
        return productsList;
    }

    public static void saveProduct(Product product) throws ResourceAlreadyExistException, JsonProcessingException {
        for (Product product1 : productsList) {
            if (product1.getProductID() == product.getProductID()) {
                throw new ResourceAlreadyExistException(product.getProductID());
            }
        }
        productsList.add(product);
        updateJson();
    }

    public static void updateJson() throws JsonProcessingException {
        // write List of Products from json file
        String newJsonData = objectMapper.writeValueAsString(productsList);
        try (PrintWriter out = new PrintWriter(new FileWriter(dbPath))) {
            out.write(newJsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setProductsList(List<Product> productsList) {
        ProductUtils.productsList = productsList;
    }

//    public static void deleteProductById(int pid) {
//        productsList = new ArrayList<>(productsList.stream().filter(
//                product -> product.getProductID() != pid
//        ).toList());
//    }

    public static void updateProducts(List<Product> products) throws ProductNotFoundException, JsonProcessingException {
        for(Product product : products){
            if (getProductByPid(product.getProductID())==null){
                throw new ProductNotFoundException(product.getProductID());
            }
            productsList.remove(getProductByPid(product.getProductID()));
            productsList.add(product);
            updateJson();
        }
    }
}
