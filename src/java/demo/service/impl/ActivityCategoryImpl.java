package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository activityCategoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository activityCategoryRepository) {
        this.activityCategoryRepository = activityCategoryRepository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return activityCategoryRepository.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return activityCategoryRepository.findAll();
    }
}