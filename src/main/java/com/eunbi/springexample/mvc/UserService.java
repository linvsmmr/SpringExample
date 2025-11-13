package com.eunbi.springexample.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getLastUser() {
        User user = userRepository.selectLastUser();

        return user;
    }

    public int createUser(String name,
                      String birthday,
                      String email,
                      String introduce) {
        int count = userRepository.insertUser(name, birthday, email, introduce);

        return count;
    }


}
