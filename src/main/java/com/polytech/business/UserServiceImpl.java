package com.polytech.business;

import com.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daivietquochoang on 14/04/2017.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(User user){
        return null;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
        //create Authority for user
        Authority authority = new Authority();
        authority.setUsername(user.getUsername());
        authority.setAuthority("USER");
        authorityService.saveAuthority(authority);
    }

}
