package com.example.studentjpaspringgit.repositories;

import com.example.studentjpaspringgit.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByNumberGroup(String numberGroup);
}
