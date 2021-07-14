package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.domain.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto, final Hire hire){
        return new Reader(
                readerDto.getReaderId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getAccountDate(),
                (List<Hire>) hire
        );
    }
    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getReaderId(),
                reader.getName(),
                reader.getSurname(),
                reader.getAccountDate()
        );
    }
    public List<ReaderDto> mapToReaderDtoList(List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
