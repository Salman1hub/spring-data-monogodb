package com.global.book.constructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.global.book.entity.Author;
import com.global.book.service.AuthorServ;


import jakarta.validation.Valid;
@RestController
@RequestMapping("/author")
public class AuthorConst {
	@Autowired
	private AuthorServ authorserv;
	
	@GetMapping("/{Id}")
	public ResponseEntity<Author> getAuthorWithBooks(@PathVariable String Id) {
		return ResponseEntity.ok(authorserv.findbyid(Id));
                
   
		
		
		
	}
/*	@PostMapping("/spec")
	public ResponseEntity<?> FindByAutharspec(@RequestBody AutharSearch authserch){
		
		return ResponseEntity.ok(autharserv.FindByautharspec(authserch));
	}*/
	 
	@GetMapping("/All")
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.ok(authorserv.findAll());

}
	@PostMapping("/insert")
	public ResponseEntity<?> add(@RequestBody @Valid  Author authar) {
		
		
		return  ResponseEntity.ok(authorserv.insert(authar));

}
@PutMapping("/up")
	public ResponseEntity<?> update(@RequestBody  Author entity) {
		
		
	try {
        return ResponseEntity.ok(authorserv.update(entity));
    } catch (ResponseStatusException e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Unexpected Error: " + e.getMessage());
    }

}
@DeleteMapping("/deleteAuthar/{Id}")
	public void DeleteById(@PathVariable String Id) {
		authorserv.DeleteById(Id);
		
		
		
	}

}
