package com.thientvse.icommerce.services.impl;

import com.thientvse.icommerce.model.User;
import com.thientvse.icommerce.repository.UserRepository;
import com.thientvse.icommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user1@gmail.com","thientvse"));
        users.add(new User("user2@gmail.com","user2"));
    }

    @Override
    public void saveInitUser() {

        User user = new User("thientvse@gmail.com", "thientvse");
        userRepository.save(user);
    }
}
