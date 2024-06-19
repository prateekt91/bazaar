package com.prat.bazaar.user;

import com.prat.bazaar.model.User;
import com.prat.bazaar.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserService userService;

    @PostMapping("/create")
    @ApiResponse(description = "API to create new User")
    public User addUser(@RequestBody User user) {
        log.info("Inside addUser for user {}", user.getUsername());
        return userService.saveUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        log.info("Inside getAllUsers");
        return userService.findAllUsers();
    }

    @GetMapping("/getUser/{username}")
    public User findUserByUsername(@PathVariable String username) {
        log.info("Inside findUserByUsername for user {}", username);
        return userService.findByUserName(username);
    }
}
