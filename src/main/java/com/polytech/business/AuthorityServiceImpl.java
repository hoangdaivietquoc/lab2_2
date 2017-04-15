package com.polytech.business;

import com.polytech.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daivietquochoang on 15/04/2017.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService{

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority findByUsername(User user) {
        return null;
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public void saveAuthority(Authority authority) {
//        authority.setAuthority("USER");
        authorityRepository.save(authority);
    }
}
