package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Hire;
import com.kodilla.kodillalibrary.repository.HireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HireDbService {

    private final HireRepository hireRepository;

    public List<Hire> getAllHires(){
        return hireRepository.findAll();
    }

    public Optional<Hire> getHire(final Long hireId) {
        return hireRepository.findById(hireId);
    }
    public void deleteHireByID(Long id){
        hireRepository.deleteById(id);
    }
}
