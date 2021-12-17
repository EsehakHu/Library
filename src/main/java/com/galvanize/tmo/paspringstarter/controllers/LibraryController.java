package com.galvanize.tmo.paspringstarter.controllers;


import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping
    public ResponseEntity<Book> addBooks(@RequestBody Book book ) {
        return new ResponseEntity<>(service.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Book> deleteAllBooks() {
        service.deleteAllBooks();
        return new ResponseEntity<>(new Book(), HttpStatus.NO_CONTENT);
    }
}
