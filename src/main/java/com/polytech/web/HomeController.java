package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String indexAction(){
        return "index";
    }

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String indexAction2(){
        return "index";
    }

}
