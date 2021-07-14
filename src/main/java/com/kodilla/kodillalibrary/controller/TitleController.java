package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.domain.TitleDto;
import com.kodilla.kodillalibrary.mapper.TitleMapper;
import com.kodilla.kodillalibrary.repository.TitleRepository;
import com.kodilla.kodillalibrary.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/title")
@RequiredArgsConstructor
public class TitleController {

    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles(){
        List<Title> titles = titleDbService.getAllTitles();
        return titleMapper.mapToTitleDtoList(titles);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto){
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
    }
}
