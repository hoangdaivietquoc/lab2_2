package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daivietquochoang on 17/03/2017.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String loggin(){
        return "login";
    }
}
