package com.prat.bazaar.repositories;

import com.prat.bazaar.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepo extends MongoRepository<Orders, String> {
}
