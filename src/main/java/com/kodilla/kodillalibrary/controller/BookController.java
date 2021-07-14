package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks(){
        List<Book> books = bookDbService.getAllBooks();
        return bookMapper.mapToBookDtoList(books);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateStatus(@RequestBody Book book){

        Book savedBook = bookDbService.saveBook(bookDto);
        return bookMapper.mapToBookDto(savedBook);
    }
}
