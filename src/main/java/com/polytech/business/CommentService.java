package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
public interface CommentService {
    void saveComment(Comment comment);
    List<Comment> findAll();
}
