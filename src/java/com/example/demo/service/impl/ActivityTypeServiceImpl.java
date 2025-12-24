package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;

    public ActivityTypeServiceImpl(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityType save(ActivityType type) {
        return repository.save(type);
    }

    @Override
    public List<ActivityType> getAll() {
        return repository.findAll();
    }
}
