package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.domain.HireDto;
import com.kodilla.kodillalibrary.domain.Reader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HireMapper {

    public Hire mapToHire(final HireDto hireDto, final Book book, final Reader reader){
        return new Hire(
                hireDto.getHireId(),
                hireDto.getDateLoan(),
                hireDto.getReturnDate(),
                book,
                reader
        );
    }
    public HireDto mapToHireDto(final Hire hire){
        return new HireDto(
                hire.getHireId(),
                hire.getDateLoan(),
                hire.getReturnDate()
        );
    }
    public List<HireDto> mapToHireDtoList(List<Hire> hireList){
        return hireList.stream()
                .map(this::mapToHireDto)
                .collect(Collectors.toList());
    }
}
