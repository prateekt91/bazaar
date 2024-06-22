package com.prat.bazaar.repositories;

import com.prat.bazaar.model.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewsRepo extends MongoRepository<Reviews, String> {

    List<Reviews> findByUserId(String userId);
}
