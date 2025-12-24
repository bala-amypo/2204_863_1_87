package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping
    public ResponseEntity<EmissionFactor> createFactor(@RequestBody EmissionFactor factor) {
        if (factor.getActivityType() == null || factor.getActivityType().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        EmissionFactor savedFactor = factorService.createFactor(factor.getActivityType().getId(), factor);
        return ResponseEntity.ok(savedFactor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getFactorById(@PathVariable Long id) {
        EmissionFactor factor = factorService.getFactor(id);
        return ResponseEntity.ok(factor);
    }

    @GetMapping("/type/{activityTypeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(@PathVariable Long activityTypeId) {
        EmissionFactor factor = factorService.getFactorByType(activityTypeId);
        return ResponseEntity.ok(factor);
    }

    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllFactors() {
        List<EmissionFactor> factors = factorService.getAllFactors();
        return ResponseEntity.ok(factors);
    }
}