package com.snt.minijira.controller;

import com.snt.minijira.config.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;


    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String loggedUserName() {
        return authenticationFacade.getName();
    }


}
