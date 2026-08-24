package com.example.Library.Management.System.service;


import com.example.Library.Management.System.entity.User;
import com.example.Library.Management.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository ;

    public UserService(UserRepository libraryRepository){
        this.userRepository=libraryRepository;
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User LoginUser(String username,String password){
        User user= userRepository.findByUsernameAndPassword(username,password);
        if(user!=null && user.getPassword().equals(password)){
            return user;
        }

    return null;


    }


}
