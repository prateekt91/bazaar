package com.prat.bazaar.repositories;

import com.prat.bazaar.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findByUsername(String username);
}
