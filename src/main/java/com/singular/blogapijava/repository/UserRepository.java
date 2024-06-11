package com.singular.blogapijava.repository;

import com.singular.blogapijava.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
