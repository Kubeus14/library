package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "readers")
public class Reader {

    private Long readerId;
    private String name;
    private String surname;
    private Date accountDate;
    private List<Hire> hires = new ArrayList<>();
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "readerId")
    public Long getReaderId() {
        return readerId;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }
    @Column(name = "accountDate")
    public Date getAccountDate() {
        return accountDate;
    }
    @OneToMany(
            targetEntity = Hire.class,
            mappedBy = "readerId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Hire> getHires() {
        return hires;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }
    public void setHires(List<Hire> hires) {
        this.hires = hires;
    }
}
