package com.galvanize.tmo.paspringstarter.controllers;


import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.model.BookStore;
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
@RequestMapping("api/books")
public class LibraryController {

    @Autowired
    LibraryService service;

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping
    public ResponseEntity<Book> addBooks(@RequestBody Book book ) {
        System.out.println("Requested to add book with details: " + book.toString());
        return new ResponseEntity<>(service.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<BookStore> getAllBooks() {
        System.out.println("Requested to get all Books: ");
        List<Book> books = service.getAllBooks();
        BookStore bookStore = new BookStore();
        bookStore.setBookList(books);
        System.out.println("sizes of Books found: " + books.size());
        books.forEach(book -> System.out.println("Found book:==" + book.toString()));
        return new ResponseEntity<>(bookStore, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Book> deleteAllBooks() {
        System.out.println("Requested to delete all Books: ");
        service.deleteAllBooks();
        return new ResponseEntity<>(new Book(), HttpStatus.NO_CONTENT);
    }
}
