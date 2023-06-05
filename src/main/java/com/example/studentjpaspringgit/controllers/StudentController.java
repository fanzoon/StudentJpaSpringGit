package com.example.studentjpaspringgit.controllers;

import com.example.studentjpaspringgit.models.Group;
import com.example.studentjpaspringgit.models.Student;
import com.example.studentjpaspringgit.services.impl.GroupServiceImpl;
import com.example.studentjpaspringgit.services.impl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private final GroupServiceImpl groupService;
    private final StudentServiceImpl studentService;

    public StudentController(GroupServiceImpl groupService, StudentServiceImpl studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String menu() {
        return "menu";
    }

    ;

    @GetMapping("/groups")
    public String getAllNumbersGroup(Model model) {
        List<Group> allGroup = groupService.getAllGroup();
        model.addAttribute("allGroups", allGroup);
        return "groups";
    }

    @GetMapping("/groups/{groupId}")
    public String getAllStudentsByGroup(@PathVariable Long groupId, Model model) {
        Group groupById = groupService.getGroupById(groupId);
        List<Student> studentListByGroup = studentService.getStudentsByGroup(groupId);
        model.addAttribute("studentsByGroup", studentListByGroup);
        model.addAttribute("groupNumber", groupById.getNumberGroup());
        return "listStudentsByGroup";
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> studentList = studentService.getAllStudent();
        model.addAttribute("allStudents", studentList);
        return "students";
    }

    @GetMapping("/noPaid")
    public String getStudentsNoPaid(Model model) {
        List<Student> studentList = studentService.getStudentsNoPaid();
        model.addAttribute("StudentsNoPaid", studentList);
        return "noPaid";
    }

    @GetMapping("/byName")
    public String getFormByName() {
        return "studentByName";
    }

    @GetMapping("/listStudentByName")
    public String getStudentsByName(@RequestParam String name, Model model) {
        List<Student> studentListByName = studentService.getStudentByName(name);
        model.addAttribute("studentByName", studentListByName);
        model.addAttribute("nameStudent", name);
        return "listStudentsByName";
    }

    @GetMapping("/bySurName")
    public String getFormBySurName() {
        return "studentBySurName";
    }

    @GetMapping("/listStudentBySurName")
    public String getStudentsBySurName(@RequestParam String surName, Model model) {
        List<Student> studentListBySurName = studentService.getStudentsBySurName(surName);
        model.addAttribute("studentBySurName", studentListBySurName);
        model.addAttribute("surNameStudent", surName);
        return "listStudentsBySurName";
    }

    @GetMapping("/changeStudentDetails/{studentId}")
    public String getFormStudent(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        List<Group> groupList = groupService.getAllGroup();
        model.addAttribute("student", student);
        model.addAttribute("allGroups", groupList);
        return "changeStudent";
    }

    @PostMapping("/changeStudent")
    public String changeStudentDetails(@RequestParam Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String surName
            , @RequestParam(required = false) boolean paid, @RequestParam(required = false) String groups, Model model) {
        Student student = studentService.changeStudent(id, name, surName, paid, groups);
        List<Group> allGroup = groupService.getAllGroup();
        model.addAttribute("allGroups", allGroup);
        return "groups";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        List<Group> allGroup = groupService.getAllGroup();
        model.addAttribute("allGroups", allGroup);
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String saveStudent(Student student, @RequestParam String group) {
        studentService.addStudent(student, group);
        return "redirect:/groups";
    }

    @PostMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/groups";
    }
}