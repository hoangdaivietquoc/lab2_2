package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 14/04/2017.
 */
public interface UserService {
    User findByUsername(User user);
    List<User> findAll();
    void saveUser(User user);
}
