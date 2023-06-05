package com.example.studentjpaspringgit.services.impl;

import com.example.studentjpaspringgit.models.Group;
import com.example.studentjpaspringgit.models.Student;
import com.example.studentjpaspringgit.repositories.GroupRepository;
import com.example.studentjpaspringgit.repositories.StudentRepository;
import com.example.studentjpaspringgit.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsNoPaid() {
        return getAllStudent()
                .stream()
                .filter(student -> !student.isPaid())
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentByName(String name) {
//        return getAllStudent()
//                .stream()
//                .filter(student -> student.getName().equals(name))
//                .collect(Collectors.toList());
        return studentRepository.findStudentByName(name);
    }

    @Override
    public List<Student> getStudentsByGroup(Long id) {
        return studentRepository.findStudentByGroups(id);
    }

    @Override
    public List<Student> getStudentsBySurName(String surName) {
        return studentRepository.findStudentBySurName(surName);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student changeStudent(Long id, String name, String surName, boolean paid, String groups) {
        Optional<Group> group = groupRepository.findByNumberGroup(groups);
        Group group1 = group.orElse(null);
        Student student = new Student(id, name, surName, paid, group1);
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public Student addStudent(Student student, String numberGroup) {
        Optional<Group> group = groupRepository.findByNumberGroup(numberGroup);
        Group group1 = group.orElse(null);
        student.setGroups(group1);
        Student save = studentRepository.save(student);
        return save;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
