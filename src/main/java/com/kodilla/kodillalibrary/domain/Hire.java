package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hires")
public class Hire {

    private Long hireId;
    private Date dateLoan;
    private Date returnDate;
    private Reader reader;
    private List<Book> books = new ArrayList<>();

    public Hire(Long hireId, Date dateLoan, Date returnDate, Book book, Reader reader) {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "hireId")
    public Long getHireId() {
        return hireId;
    }
    @Column(name = "dateLoan")
    public Date getDateLoan() {
        return dateLoan;
    }
    @Column(name = "dateReturn")
    public Date getReturnDate() {
        return returnDate;
    }
    @ManyToOne
    @JoinColumn(name = "readerId")
    public Reader getReader() {
        return reader;
    }
    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "hireId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Book> getBooks() {
        return books;
    }

    public void setHireId(Long hireId) {
        this.hireId = hireId;
    }
    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public void setReader(Reader reader) {
        this.reader = reader;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
