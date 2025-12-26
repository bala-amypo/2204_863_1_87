package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.EmissionFactorService;

import java.util.List;

public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    public EmissionFactorServiceImpl(
            EmissionFactorRepository factorRepository,
            ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public EmissionFactor createFactor(Long activityTypeId,
                                       EmissionFactor factor) {

        if (factor.getFactorValue() <= 0) {
            throw new ValidationException("Factor value must be greater than zero");
        }

        ActivityType type = typeRepository.findById(activityTypeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        factor = new EmissionFactor(
                null,
                type,
                factor.getFactorValue(),
                factor.getUnit(),
                null
        );

        return factorRepository.save(factor);
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return factorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emission factor not found"));
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Emission factor not found"));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}
