package com.polytech.business;

import com.polytech.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daivietquochoang on 16/04/2017.
 */
@Service
public class LikeServiceImpl implements LikeService {

    LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }
    @Override
    public void saveLike(Like like) {
        if(!isExist(like)){
            likeRepository.save(like);
        }
        else{
            Like l = find(like.getIdPost(),like.getUsername());
            if(l!=null){likeRepository.delete(l);}
        }

    }

    @Override
    public void changeLike(Like like) {
        if(!isExist(like)){
            likeRepository.save(like);
        }
        else{
            Like l = find(like.getIdPost(),like.getUsername());
            if(l!=null){likeRepository.delete(l);}
        }
    }

    @Override
    public List<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public boolean isExist(Like like) {
        List<Like> lsLike = likeRepository.findAll();
        for(Like l : lsLike){
            if(like.getUsername().equals(l.getUsername())&&like.getIdPost()==l.getIdPost()){return true;}
        }
        return false;
    }

    @Override
    public List<Like> findByidPost(Long idPost) {
        List<Like> lsResult = new ArrayList<Like>();
        List<Like> lsLike = likeRepository.findAll();
        for(Like l : lsLike){
            if(idPost==l.getIdPost()){
                lsResult.add(l);
            }
        }
        return lsResult;
    }

    @Override
    public int getNumberLikeByIdPost(Long idPost) {
        int numLike = 0;
        List<Like> lsLike = likeRepository.findAll();
        for(Like l : lsLike){
            if(idPost==l.getIdPost()){
                numLike++;
            }
        }
        return numLike;
    }

    @Override
    public Like find(Long idPost, String username) {
        List<Like> lsLike = likeRepository.findAll();
        for(Like l : lsLike){
            if(idPost==l.getIdPost()&&username.equals(l.getUsername())){
                return l;
            }
        }
        return null;
    }
}
