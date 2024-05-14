package com.singular.blogapijava.repository;

import com.singular.blogapijava.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, Long> {

}
