package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 16/03/2017.
 */
public interface PublicationService {
    void post(Post post);

    List<Post> fetchAll();
}
