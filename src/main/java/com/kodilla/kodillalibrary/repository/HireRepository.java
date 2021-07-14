package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HireRepository extends CrudRepository<Hire,Long> {

    @Override
    List<Hire> findAll();

    @Override
    Hire save(Hire hire);

    @Override
    Optional<Hire> findById(Long id);

    @Override
    void deleteById(Long id);
}
