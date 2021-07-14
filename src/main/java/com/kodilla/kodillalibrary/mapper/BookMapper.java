package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.domain.Title;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto, final Title title, final Hire hire){
        return  new Book(
                bookDto.getBookId(),
                bookDto.getTitleId(),
                bookDto.getStatus(),
                title,
                hire
        );
    }
    public BookDto mapToBookDto(final  Book book){
        return new BookDto(
                book.getBookId(),
                book.getTitleId(),
                book.getStatus()
        );
    }
    public List<BookDto> mapToBookDtoList(final List<Book> bookList){
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
