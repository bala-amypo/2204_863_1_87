package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceImpl {
    ActivityCategory createCategory(ActivityCategory category);
    List<ActivityCategory> getAllCategories();
}
