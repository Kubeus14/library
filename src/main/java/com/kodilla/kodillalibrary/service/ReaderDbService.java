package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.Reader;
import com.kodilla.kodillalibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReaderDbService {

        private final ReaderRepository readerRepository;

        public List<Reader> getAllReaders() {
            return readerRepository.findAll();
        }

        public Reader saveReader(final Reader reader) {
            return readerRepository.save(reader);
        }
}
