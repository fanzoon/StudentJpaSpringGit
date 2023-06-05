package com.example.studentjpaspringgit.services;

import com.example.studentjpaspringgit.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    List<Student> getStudentsNoPaid();

    List<Student> getStudentByName(String name);

    List<Student> getStudentsByGroup(Long id);

    List<Student> getStudentsBySurName(String surname);

    Student getStudentById(Long studentId);

    Student changeStudent(Long id, String name, String surName, boolean paid, String groups);

    Student addStudent(Student student, String numberGroup);

    void deleteStudent(Long id);
}
