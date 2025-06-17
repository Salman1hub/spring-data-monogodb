package com.global.book.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.global.book.entity.Author;

@Repository
public interface AuthorRepo extends MongoRepository<Author, String>{

}
