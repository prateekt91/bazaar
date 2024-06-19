package com.prat.bazaar.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.prat.bazaar.model.Product;
import com.prat.bazaar.product.ProductController;
import com.prat.bazaar.repositories.ProductsRepo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Autowired
    MongoOperations mongoOperations;

    private static final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

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

        log.info("Inside method geProductDetailsBySearchKeyword");
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

    @Override
    public Boolean createNewProducts(List<Product> products) {

        List <Product> createdProducts = productsRepo.saveAll(products);

        return !createdProducts.isEmpty();

    }

    @Override
    public Boolean updateExistingProduct(Product product) {
        log.info("Inside method updateExistingProduct");
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("name").is(product.getName()));
            Update update = new Update();
            update.set("description", product.getDescription());
            update.set("name", product.getName());
            update.set("stock", product.getStock());
            update.set("price", product.getPrice());
            update.set("category", product.getCategory());
            mongoOperations.findAndModify(
                    query,update,
                    new FindAndModifyOptions().returnNew(true),
                    Product.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
