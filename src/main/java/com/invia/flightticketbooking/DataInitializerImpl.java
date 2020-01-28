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
        user.setEmail("varathu09@gmail.com");
        user.setFirstname("varadharajan");
        user.setLastname("damotharan");
        user.setPassword("1234512345");
        user.setUsername("varadharajaan");

        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(user);
        Role role = new Role();
        role.setName("ADMIN");
        role.setUsers(listOfUsers);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        //roleRepository.save(role);
        //userRepository.save(user);

        Flight flight = new Flight();

        Airport arrAirport = new Airport();


        Aircraft aircraft = new Aircraft();

        List<User> users = userRepository.findAll();
        users.forEach(User::getId);


    }


}
