package com.example.ecom.demo.controller;

import com.example.ecom.demo.entity.Product;
import com.example.ecom.demo.utils.ProductsUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductsController {
    //TODO : JSON
    @GetMapping("/api/v1/products")
    ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(ProductsUtil.getProductsList(), HttpStatus.OK);
    }

    // Handle exception from controller advisor
    // Use Wrappers wherever possible
    @GetMapping("/api/v1/products/{pid}")
    ResponseEntity<Product> getProductByPid(@PathVariable Integer pid) {
        List<Product> products = ProductsUtil.getProductsList().stream().filter(p -> p.getProductID() == pid).toList();
//        if (!products.isEmpty()) {
            return new ResponseEntity<>(products.get(0), HttpStatus.OK);
//        }
        //return new ResponseEntity<>("No product found with pid " + pid, HttpStatus.NOT_FOUND);
    }

    // store in json
    // return response entity
    @PostMapping("/api/v1/products")
    ResponseEntity<String> saveProduct(@RequestBody List<Product> products) {
//        try {
//            int productID = Integer.parseInt(body.get("productID").toString());
//            int supplierID = Integer.parseInt(body.get("supplierID").toString());
//            int unit = Integer.parseInt(body.get("unit").toString());
//            int price = Integer.parseInt(body.get("price").toString());
//            String name = body.get("name").toString();
//            ProductsUtil.insertProduct(new Product(productID, supplierID, unit, price, name));
//        } catch (Exception e) {
//            return HttpStatus.BAD_REQUEST;
//        }
        for (Product p : products){
            ProductsUtil.saveProduct(p);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/api/v1/product")
    //accept list of products for bulk updates
    //use same json to update
    ResponseEntity<String> updateProduct(@RequestBody Map<String, Object> body) {
        try {
            Product p = (Product) getProductByPid(Integer.parseInt(body.get("productID").toString())).getBody();
            if (p != null) {
                if (body.containsKey("supplierID")) {
                    p.setSupplierID(Integer.parseInt(body.get("supplierID").toString()));
                }
                if (body.containsKey("unit")) {
                    p.setUnit(Integer.parseInt(body.get("unit").toString()));
                }
                if (body.containsKey("price")) {
                    p.setPrice(Integer.parseInt(body.get("price").toString()));
                }
                if (body.containsKey("name")) {
                    p.setProductName(body.get("name").toString());
                }
                ProductsUtil.deleteProductById(p.getProductID());
                ProductsUtil.saveProduct(p);
                return new ResponseEntity<>("Product information is updated successfully", HttpStatus.OK);
            }
        } catch ( NumberFormatException | ClassCastException e) {
            if (e instanceof ClassCastException) {
                return new ResponseEntity<>("Invalid Product ID ", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("INVALID INPUT FOR ONE OF THE NUMERIC FIELDS", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



