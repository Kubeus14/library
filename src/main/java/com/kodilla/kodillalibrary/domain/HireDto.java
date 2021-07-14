package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class HireDto {

    private Long hireId;
    private Date dateLoan;
    private Date returnDate;
}
