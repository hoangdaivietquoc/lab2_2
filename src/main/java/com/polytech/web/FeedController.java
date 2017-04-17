package com.polytech.web;

import com.polytech.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
@RestController
public class FeedController {
    @Autowired
    PostService postService;

    @Autowired
    LikeService likeService;
    @RequestMapping(value="/share",method = RequestMethod.POST)
    public ResponseEntity<?> testAction(@Valid @RequestBody Post post, Error error, Principal principal){
        post.setUsername(principal.getName());
        postService.savePost(post);
        List<Post> lsPost = postService.findAll();
        return ResponseEntity.ok(lsPost);
    }

    @RequestMapping(value="/showLike",method = RequestMethod.POST)
    public ResponseEntity<?> showLikeAction(Error error, Principal principal){
        LikePostInforServiceImpl likePostInforServiceImpl = new LikePostInforServiceImpl();
        List<Like> lsLike = likeService.findAll();
        for(Like l:lsLike){
            likePostInforServiceImpl.push(l);
        }
        return ResponseEntity.ok(likePostInforServiceImpl.getLsLP());
    }

    @RequestMapping(value="/refreshFeed",method = RequestMethod.POST)
    public ResponseEntity<?> refreshFeedAction(Error error, Principal principal){
        return ResponseEntity.ok(postService.findAll());
    }
    @RequestMapping(value="/changeLike",method = RequestMethod.POST)
    public ResponseEntity<?> changeLikeAction(@Valid @RequestBody Like like,Error error, Principal principal){
        like.setUsername(principal.getName());
        likeService.changeLike(like);
        return ResponseEntity.ok(like);
    }

}
