package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReaderDto {

    private Long readerId;
    private String name;
    private String surname;
    private Date accountDate;
}
