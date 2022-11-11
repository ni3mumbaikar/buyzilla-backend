package com.example.ecom.demo.utils;

import com.example.ecom.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsUtil {
    public static void init() {
        productsList = new ArrayList<>(List.of(
                new Product(321, 5564, 20, 1299, "Boat 543 TWS Black"),
                new Product(458, 5288, 80, 66990, "Apple iPhone 13 Mini 128GB Blue"),
                new Product(983, 5564, 50, 86399, "Canon EOS 80D 24.2MP Digital Camera"),
                new Product(893, 5521, 93, 19999, "Samsung Galaxy watch 4 Bluetooth"),
                new Product(903, 9923, 40, 3999, "All new Amazon Echo dot (4th gen)")
        ));
    }

    private static List<Product> productsList;

    public static List<Product> getProductsList() {
        return productsList;
    }

    public static void saveProduct(Product product) {
        productsList.add(product);
    }

    public static void setProductsList(List<Product> productsList) {
        ProductsUtil.productsList = productsList;
    }

    public static void deleteProductById(int pid) {
        productsList = new ArrayList<>(productsList.stream().filter(
                product -> product.getProductID() != pid
        ).toList());
    }

}
