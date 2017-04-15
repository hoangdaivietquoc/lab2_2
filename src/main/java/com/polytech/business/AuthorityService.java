package com.polytech.business;

import java.util.List;

/**
 * Created by daivietquochoang on 15/04/2017.
 */
public interface AuthorityService {
    Authority findByUsername(User user);
    List<Authority> findAll();
    void saveAuthority(Authority authority);
}
