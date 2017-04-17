package com.polytech.web;

import com.polytech.business.Comment;
import com.polytech.business.CommentService;
import com.polytech.business.Post;
import com.polytech.business.PostService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/showPostContent",method = RequestMethod.POST)
    public ResponseEntity<?> showPostContentAction(@Valid @RequestBody String data, Error error, Principal principal){
        Long idPost = Long.valueOf(data.replaceAll("[^0-9]", ""));
        System.out.println("showPostContentAction: idPost = "+idPost+"---"+data);
        return ResponseEntity.ok(postService.findById(idPost));
    }

    @RequestMapping(value="/addComment",method = RequestMethod.POST)
    public ResponseEntity<?> addCommentContentAction(@Valid @RequestBody Comment comment, Error error, Principal principal){
        comment.setUsername(principal.getName());
        System.out.println(comment.getIdPost()+"---"+comment.getContent()+"----"+comment.getUsername());
        commentService.saveComment(comment);
        List<Comment> lsComment = commentService.findAll();
        return ResponseEntity.ok(lsComment);
    }

    @RequestMapping(value="/showComments",method = RequestMethod.POST)
    public ResponseEntity<?> showCommentsContentAction(@Valid @RequestBody Comment comment, Error error, Principal principal){
        comment.setUsername(principal.getName());
        System.out.println(comment.getIdPost()+"---"+comment.getContent()+"----"+comment.getUsername());
        List<Comment> lsComment = commentService.findAll();
        return ResponseEntity.ok(lsComment);
    }
}
