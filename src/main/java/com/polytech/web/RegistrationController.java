package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.User;
import com.polytech.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

/**
 * Created by daivietquochoang on 14/04/2017.
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/registration",method = RequestMethod.POST)
    public String registrationAction(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        List<User> lsUser= userService.findAll();
        /*System.out.println(lsUser.size());
        for(int i=0;i<lsUser.size();i++){
            System.out.println(lsUser.get(i));
        }*/
        return "redirect:feed";
    }
}
