package com.doctorapp.repository;

import com.doctorapp.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser,Integer> {

    AppUser findByUsername(String username);
}
