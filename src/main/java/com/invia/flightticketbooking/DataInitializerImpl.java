package com.invia.flightticketbooking;


import com.invia.flightticketbooking.model.*;
import com.invia.flightticketbooking.repository.RoleRepository;
import com.invia.flightticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Varadharajan
 */
@Component
@Transactional
public class DataInitializerImpl {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void initData() {

        User user = new User();
        user.setEmail("aaabbcc@gmail.com");
        user.setFirstname("varadha");
        user.setLastname("rajan");
        user.setPassword("password");
        user.setUsername("varadharajan");
        user.setRoles(null);

        //roleRepository.save(role);
        //userRepository.save(user);


        //userRepository.save(user);

        List<User> users = userRepository.findAll();
        users.forEach(User::getId);


    }


}
