package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 15/04/2017.
 */
public interface PostService {
    Post findByUser(User user);
    Post findById(Long id);
    List<Post> findAll();
    void savePost(Post post);
}
