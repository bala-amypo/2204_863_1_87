package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType save(ActivityType type);

    List<ActivityType> getAll();
}
