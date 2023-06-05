package com.example.studentjpaspringgit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number_group")
    private String numberGroup;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<com.example.studentjpaspringgit.models.Student> students = new ArrayList<>();
}