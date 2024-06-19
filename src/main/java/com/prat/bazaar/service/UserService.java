package com.prat.bazaar.service;

import com.prat.bazaar.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public User findByUserName(String username);

    public List<User> findAllUsers();
}
