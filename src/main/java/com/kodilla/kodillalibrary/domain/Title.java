package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "titles")
public class Title {
    private Long titleId;
    private String title;
    private String author;
    private int pubYear;
    private List<Book> books = new ArrayList<>();
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "titleId", unique = true)
    public Long getTitleId() {
        return titleId;
    }
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }
    @Column(name = "pubYear")
    public int getPubYear() {
        return pubYear;
    }
    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Book> getBooks() {
        return books;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }





}
