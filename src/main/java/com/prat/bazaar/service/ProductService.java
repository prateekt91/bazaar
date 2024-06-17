package com.prat.bazaar.service;

import com.prat.bazaar.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(String id);

    List<Product> geProductDetailsBySearchKeyword(String keyword);
}
