package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.domain.ReaderDto;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.TitleDto;
import com.kodilla.kodillalibrary.mapper.ReaderMapper;
import com.kodilla.kodillalibrary.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReaders")
    public List<ReaderDto> getReaders(){
        List<Reader> readers = readerDbService.getAllReaders();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto){
        Reader reader = readerMapper.mapToReader(readerDto);
        readerDbService.saveReader(reader);
    }
}
