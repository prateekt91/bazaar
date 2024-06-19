package com.prat.bazaar.service;

import com.prat.bazaar.encryption.Encrypt;
import com.prat.bazaar.model.User;
import com.prat.bazaar.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    Encrypt encrypt;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        try {
            user.setPassword(encrypt.hashPassword(user.getPassword()));
            return userRepo.save(user);
        } catch (Exception e) {
            log.error("Error in saving user", e);
            return null;
        }
    }

    @Override
    public User findByUserName(String username) {

        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
