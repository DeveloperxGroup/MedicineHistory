/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developerxgroup.medicinehistory.service;


import com.developerxgroup.medicinehistory.model.*;
import com.developerxgroup.medicinehistory.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 *
 * @author Abdelrahman.Ahmad
 */
@Component
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public Users findUsersByID(Integer id) throws Exception{
        Optional<Users> optionalUsers = usersRepository.findById(id);
        return optionalUsers.get();
    }
    public List<Users> findAll() throws Exception{
        List<Users> optionalUsers = (List<Users>) usersRepository.findAll();
        return optionalUsers;
    }
    public Users updateser(Users user){
        return usersRepository.save(user);
    }
}
