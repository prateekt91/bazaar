package com.prat.bazaar.service;

import com.prat.bazaar.model.Product;
import com.prat.bazaar.repositories.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public List<Product> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productsRepo.findById(id).orElseThrow();
    }


}
