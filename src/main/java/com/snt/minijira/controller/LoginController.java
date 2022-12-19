package com.snt.minijira.controller;

import com.snt.minijira.config.MyUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public boolean login(@RequestBody MyUserDetails user) {
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];

    }
}
