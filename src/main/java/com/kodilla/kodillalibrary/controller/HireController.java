package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.domain.HireDto;
import com.kodilla.kodillalibrary.mapper.HireMapper;
import com.kodilla.kodillalibrary.service.HireDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hire")
@RequiredArgsConstructor
public class HireController {

    private final HireDbService hireDbService;
    private final HireMapper hireMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getHires")
    public List<HireDto> getHires(){
        List<Hire> hires = hireDbService.getAllHires();
        return hireMapper.mapToHireDtoList(hires);
    }
    @RequestMapping(method = RequestMethod.GET, value = "getHire")
    public HireDto getHire(@RequestParam Long hireId) throws HireNotFoundException {
        return hireMapper.mapToHireDto(
                hireDbService.getHire(hireId).orElseThrow(HireNotFoundException::new)
        );
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteHireByID")
    public void deleteHireBYID( @RequestParam Long hireId) throws HireNotFoundException {

        if (hireDbService.getHire(hireId).isPresent())
            hireDbService.deleteHireByID(hireId);
        else
            throw new HireNotFoundException();
    }
}
