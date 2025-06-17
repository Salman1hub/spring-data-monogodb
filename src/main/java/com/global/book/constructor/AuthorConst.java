package com.global.book.constructor;

import com.global.book.entity.Author;
import com.global.book.service.AuthorServ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/author")
// this should be controller not constructor
public class AuthorConst {

    // it's better to use constructor injection instead of autowiring for better testability
    @Autowired
    private AuthorServ authorserv;

    // paramterrs should be in small cases like "/{id}" instead of "/{Id}"
    @GetMapping("/{Id}")
    public ResponseEntity<Author> getAuthorWithBooks(@PathVariable String Id) {
        return ResponseEntity.ok(authorserv.findbyid(Id));


    }
/*	@PostMapping("/spec")
	public ResponseEntity<?> FindByAutharspec(@RequestBody AutharSearch authserch){
		
		return ResponseEntity.ok(autharserv.FindByautharspec(authserch));
	}*/

    // all mappings should be small cases like "/all" instead of "/All"
    @GetMapping("/All")
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(authorserv.findAll());

    }

    @PostMapping("/insert")
    public ResponseEntity<?> add(@RequestBody @Valid Author authar) {


        return ResponseEntity.ok(authorserv.insert(authar));

    }



    @PutMapping("/up")
    public ResponseEntity<?> update(@RequestBody Author entity) {


        try {
            return ResponseEntity.ok(authorserv.update(entity));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Unexpected Error: " + e.getMessage());
        }

    }

	// this should be delete not deleteAuthar and same comment for id not Id
    @DeleteMapping("/deleteAuthar/{Id}")
    public void DeleteById(@PathVariable String Id) {
        authorserv.DeleteById(Id);


    }

}
