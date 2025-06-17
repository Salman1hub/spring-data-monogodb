package com.global.book;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.entity.Author;
import com.global.book.repo.AuthorRepo;
@Component
public class StartupAPP implements CommandLineRunner {
@Autowired
	private AuthorRepo authrepo;
	public void run(String... args) throws Exception {
		if(authrepo.findAll().isEmpty()) {
		Author author1 = new Author();
		author1.setName("Mohamed");
		author1.setEmail("mh@gmail.com");
		author1.setPhone("01159431034");
		
		
		Author author2= new Author();
		author2.setName("Ali");
		author2.setEmail("al@gmail.com");
		author2.setPhone("01112431034");
		
		Author author3 = new Author();
		author3.setName("mahmoud");
		author3.setEmail("mz@gmail.com");
		author3.setPhone("01159124034");
		
		Author author4 = new Author();
		author4.setName("Saeed");
		author4.setEmail("sd@gmail.com");
		author4.setPhone("01159431434");
		
		authrepo.insert(Arrays.asList(author1,author2,author3,author4));
		}
	}

}
