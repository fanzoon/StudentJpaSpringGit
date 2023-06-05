package com.example.studentjpaspringgit.repositories;

import com.example.studentjpaspringgit.models.Group;
import com.example.studentjpaspringgit.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByName(String name);

    @Query(value = "SELECT * FROM students WHERE groups_id = ?;", nativeQuery = true)
    List<Student> findStudentByGroups(Long id);

    List<Student> findStudentBySurName(String surName);
}
