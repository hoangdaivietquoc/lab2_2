package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
public interface LikeService {
    //method saveLike and changeLike will insert or delete a like if it exists
    void saveLike(Like like);
    void changeLike(Like like);
    List<Like> findAll();
    boolean isExist(Like like);
    //method findByidPost return a list of Likes that have the same idPost
    List<Like> findByidPost(Long idPost);
    int getNumberLikeByIdPost(Long idPost);
    Like find(Long idPost,String username);
}
