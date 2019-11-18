/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developerxgroup.medicinehistory.repo;


import com.developerxgroup.medicinehistory.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Abdelrahman.Ahmad
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
