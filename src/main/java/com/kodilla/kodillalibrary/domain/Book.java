package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {
    private Long bookId;
    private Long titleId;
    private int status;
    private Title title;
    private Hire hire;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "bookId")
    public Long getBookId() {
        return bookId;
    }
    @Column(name = "titleId")
    public Long getTitleId() {
        return titleId;
    }
    @Column(name = "status")
    public int getStatus() {
        return status;
    }
    @ManyToOne
    @JoinColumn(name = "titleId")
    public Title getTitle() {
        return title;
    }
    @ManyToOne
    @JoinColumn(name = "hireId")
    public Hire getHire() {
        return hire;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public void setHire(Hire hire) {
        this.hire = hire;
    }


}
