package com.sk.sampleMS.domain.sample.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.sk.sampleMS.domain.sample.model.*;
import com.sk.sampleMS.domain.sample.repository.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    
    public List<User> getUserInfoAll(){
        return userRepository.getUserInfoAll();
    }
    
    public void adduserInfo(User user){
        userRepository.adduserInfo(user);
    }
    
    public List<User> findByUserNameLike(String userName){
        return userRepository.findByUserNameLike(userName);
    }
    
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    
    public List<User> findByForeach(Map<String, Object> paramMap){
        return userRepository.findByForeach(paramMap);
    }
}
