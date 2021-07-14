package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TitleDto {
    private Long titleId;
    private String title;
    private String author;
    private int pubYear;

}
