package business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
@Service
public class PublicationServiceImpl implements PublicationService{

    private PostRepository postRepository;

    @Autowired
    public PublicationServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void post(Post post) {
        postRepository.save(post);
    }

    public List<Post> fetchAll() {
        return postRepository.findAll();
    }
}
