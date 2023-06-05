package com.example.studentjpaspringgit.services.impl;

import com.example.studentjpaspringgit.models.Group;
import com.example.studentjpaspringgit.repositories.GroupRepository;
import com.example.studentjpaspringgit.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }
}
