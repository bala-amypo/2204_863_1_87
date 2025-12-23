package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository repository;

    public EmissionFactorServiceImpl(EmissionFactorRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmissionFactor getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EmissionFactor not found with id " + id
                        )
                );
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return repository.findAll();
    }
}
