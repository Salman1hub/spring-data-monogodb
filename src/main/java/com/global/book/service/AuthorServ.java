package com.global.book.service;

import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServ {
    @Autowired
    private AuthorRepo authrepo;

    public Author findbyid(String Id) {

        return authrepo.findById(Id).orElseThrow(() -> new RuntimeException("Author with id " + Id + " not found"));
    }

    public List<Author> findAll() {
        // always always add logs here for better debugging
        return authrepo.findAll();

    }

    public Author insert(Author auth) {
        if (auth.getId() != null) {
            throw new RuntimeException();
        }

        return authrepo.save(auth);

    }

    public List<Author> insertAll(List<Author> entity) {


        return authrepo.saveAll(entity);

    }

    public Author update(Author entity) {

        Author author = findbyid(entity.getId());
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        author.setPhone(entity.getPhone());


        return authrepo.save(author);

    }

    public void DeleteById(String id) {
        authrepo.deleteById(id);


    }
}
