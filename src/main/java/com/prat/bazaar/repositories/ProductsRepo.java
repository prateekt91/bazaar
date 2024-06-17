package com.prat.bazaar.repositories;

import com.prat.bazaar.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepo extends MongoRepository<Product,String> {
}
