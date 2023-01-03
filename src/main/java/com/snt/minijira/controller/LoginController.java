package com.snt.minijira.controller;

import com.snt.minijira.config.IAuthenticationFacade;
import com.snt.minijira.config.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @RequestMapping("/login")
    public boolean login(@RequestBody MyUserDetails user) {
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }


    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String loggedUserName() {
//        Authentication authentication = authenticationFacade.getAuthentication();
        return authenticationFacade.getName();
    }



}
