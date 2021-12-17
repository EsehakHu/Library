package com.galvanize.tmo.paspringstarter.model;

import java.util.Objects;
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

  public Book(Long id, String author, String title, Integer yearPublished) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.yearPublished = yearPublished;
  }

  public Book() {
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(getId(), book.getId()) && Objects.equals(getAuthor(),
        book.getAuthor()) && Objects.equals(getTitle(), book.getTitle())
        && Objects.equals(getYearPublished(), book.getYearPublished());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getAuthor(), getTitle(), getYearPublished());
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", author='" + author + '\'' +
        ", title='" + title + '\'' +
        ", yearPublished=" + yearPublished +
        '}';
  }
}
