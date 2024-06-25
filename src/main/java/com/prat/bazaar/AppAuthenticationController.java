package com.prat.bazaar;

import com.prat.bazaar.model.User;
import com.prat.bazaar.model.UserCred;
import com.prat.bazaar.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AppAuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AppAuthenticationController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/")
    @ApiResponse(description = "Authenticate User")
    public boolean authenticate(@RequestBody UserCred userCred) {

        log.info("Authenticating user: {}", userCred.getUserId());

        User userFromDB = userService.findByUserName(userCred.getUserId());
        return BCrypt.checkpw(userCred.getPassword(), userFromDB.getPassword());

    }

}
