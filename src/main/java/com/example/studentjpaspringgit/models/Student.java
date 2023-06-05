package com.example.studentjpaspringgit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "paid")
    private boolean paid;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private com.example.studentjpaspringgit.models.Group groups;
}
