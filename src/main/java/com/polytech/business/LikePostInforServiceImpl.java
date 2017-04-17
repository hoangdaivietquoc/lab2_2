package com.polytech.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by daivietquochoang on 17/04/2017.
 */
public class LikePostInforServiceImpl{
    private List<LikePostInfor> lsLP;
    private HashMap<Long,LikePostInfor> hmLP;


    public LikePostInforServiceImpl(){

        lsLP = new ArrayList<LikePostInfor>();
        hmLP = new HashMap<Long, LikePostInfor>();
    }

    public List<LikePostInfor> getLsLP() {
        return lsLP;
    }

    public void setLsLP(List<LikePostInfor> lsLP) {
        this.lsLP = lsLP;
    }


    public LikePostInfor findByIdPost(Long idPost) {
        return null;
    }


    public void push(Like like) {

        System.out.println(lsLP.size());
        if(lsLP.size()==0){
            lsLP.add(new LikePostInfor(like.getIdPost(),like.getUsername()));
        }
        else{
            ListIterator<LikePostInfor> litr = lsLP.listIterator();
            boolean isExisted = false;
            while(litr.hasNext()) {
                LikePostInfor element = litr.next();
                if(element.getIdPost() == like.getIdPost()){
                    isExisted = true;
                    element.addUserLike(like.getUsername());
                }

            }
            if(!isExisted){
                lsLP.add(new LikePostInfor(like.getIdPost(),like.getUsername()));
            }

        }


    }
}
