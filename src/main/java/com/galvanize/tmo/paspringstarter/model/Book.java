package com.galvanize.tmo.paspringstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue
  @Column(updatable = false, nullable = true)
  Long id;

  @Column
  String author;
  @Column
  String title;
  @Column
  Integer yearPublished;

  public void setId(Long id) {
    this.id = id;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYearPublished(Integer yearPublished) {
    this.yearPublished = yearPublished;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public Integer getYearPublished() {
    return yearPublished;
  }
}
