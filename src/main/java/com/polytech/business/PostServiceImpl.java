package com.polytech.business;

import com.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daivietquochoang on 15/04/2017.
 */
@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public Post findByUser(User user) {
        return null;
    }

    @Override
    public Post findById(Long id) {
        List<Post> lsPost = postRepository.findAll();
        for(Post p : lsPost){
            if(p.getId() == id){
                return p;
            }
        }

        return null;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {
    postRepository.save(post);
    }
}
