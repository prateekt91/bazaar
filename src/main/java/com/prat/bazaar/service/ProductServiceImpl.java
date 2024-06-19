package com.prat.bazaar.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prat.bazaar.model.Product;
import com.prat.bazaar.repositories.ProductsRepo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Product> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productsRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Product> geProductDetailsBySearchKeyword(String keyword) {

        List<Product> products = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("bazaar");
        MongoCollection<Document> collection = database.getCollection("Products");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", keyword)
                                        .append("path", Arrays.asList("description", "name")))),
                new Document("$sort",
                        new Document("stock", 1L))));
               // new Document("$limit", 10L)));

        result.forEach(product -> products.add(mongoConverter.read(Product.class,product)));

        return products;
    }


}
