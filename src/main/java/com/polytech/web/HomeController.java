package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
//HomeController will redirect, forward some adresses
@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String indexAction(){
        return "index";
    }

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String indexAction2(){
        return "index";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feedAction(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "feed";
    }


    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String postAction(@RequestParam("idPost") Long idPost, Model model,RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("idPost", idPost);
        return "post";
    }
}
