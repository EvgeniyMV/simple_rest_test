package com.example.rest_test.controller;
import com.example.rest_test.model.Fact;
import com.example.rest_test.model.FactAuthor;
import com.example.rest_test.service.FactService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class FactController {
    private final FactService factService;

    @Autowired
    public FactController(FactService factService) {
        this.factService = factService;
    }

    @PostMapping(value = "/facts")
    public ResponseEntity<?> create(@RequestBody Fact fact) {
        System.out.println(fact.toString());
        factService.create(fact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/facts/id={id}")
    public ResponseEntity<Fact> read (@PathVariable (name = "id") int factId) {
        var fact =  factService.read(factId);
        return fact != null? new ResponseEntity<>(fact, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/facts")
    public ResponseEntity<List<Fact>> readAll () {
        var responseList = factService.readAll();
        return responseList.isEmpty()? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping(value = "/facts/author={author}")
    public ResponseEntity<List<Fact>> readByAuthor(@PathVariable(name = "author") String factAuthorName) {
        var factAuthor = new FactAuthor();
        factAuthor.setName(factAuthorName);
        var responseList = factService.readByAuthor(factAuthor);
        return responseList.isEmpty()? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PutMapping(value = "/facts/id={id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") int factId, @RequestBody Fact fact) {
        var updated = factService.update(fact, factId);
        return updated? new  ResponseEntity<> (HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/facts/id={id}")
    public ResponseEntity<?> delete (@PathVariable(name = "id") int factId) {
        var deleted = factService.delete(factId);
        return deleted? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
