package com.example.studentjpaspringgit.services;

import com.example.studentjpaspringgit.models.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();

    Group getGroupById(Long groupId);
}

