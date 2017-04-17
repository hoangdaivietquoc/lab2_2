package com.polytech.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daivietquochoang on 17/04/2017.
 * contain informations of one post about it's "likes"
 */

public class LikePostInfor {
    //idPost
    private Long idPost;
    //number of "like" of this post
    private Long nbLike;
    // if user current like this post
    private boolean isliked;
    //list of users who liked the post
    private List<String> lsUserLike;

    public LikePostInfor(){
        this.isliked = false;
        this.idPost = Long.valueOf(0);
        this.lsUserLike = new ArrayList<String>();
        this.nbLike = Long.valueOf(lsUserLike.size());
    }

    public LikePostInfor(Long idPost,String username){
        this.isliked = false;
        this.idPost = idPost;
        this.lsUserLike = new ArrayList<String>();
        lsUserLike.add(username);
        this.nbLike = Long.valueOf(lsUserLike.size());
    }

    public void addUserLike(String username){
        this.lsUserLike.add(username);
        this.nbLike = Long.valueOf(lsUserLike.size());
    }

    @Override
    public String toString() {
        return "idPost = "+idPost+" nbLike = "+nbLike+" lsUserLike = "+lsUserLike;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getNbLike() {
        return nbLike;
    }

    public void setNbLike(Long nbLike) {
        this.nbLike = nbLike;
    }

    public boolean isIsliked() {
        return isliked;
    }

    public void setIsliked(boolean isliked) {
        this.isliked = isliked;
    }

    public List<String> getLsUserLike() {
        return lsUserLike;
    }

    public void setLsUserLike(List<String> lsUserLike) {
        this.lsUserLike = lsUserLike;
    }
}
