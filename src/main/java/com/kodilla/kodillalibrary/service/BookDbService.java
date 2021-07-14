package com.kodilla.kodillalibrary.service;


import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Title;
import com.kodilla.kodillalibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }
}
