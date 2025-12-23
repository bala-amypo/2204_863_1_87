package com.example.demo.service;

import com.example.demo.entity.ActivityLog;

import java.util.List;

public interface ActivityLogService {

    ActivityLog save(ActivityLog log);

    List<ActivityLog> getAll();
}
