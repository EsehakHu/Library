package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.model.Book;
import com.galvanize.tmo.paspringstarter.dao.LibraryRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

  @Autowired
  LibraryRepo libraryRepo;

  public Book saveBook(Book book) {
    return libraryRepo.save(book);
  }

  public List<Book> getAllBooks() {
    return libraryRepo.findByOrderByTitle();
  }

  public void deleteAllBooks() {
    libraryRepo.deleteAll();
  }


}
