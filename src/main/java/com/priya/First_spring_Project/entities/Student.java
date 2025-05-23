package com.priya.First_spring_Project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity  // object of this class is directly going to be mapped with a database table
@Table(name = "Student")  // can define table name like this. If table name is not given then className is treated as table name by default. 
@Getter
@Setter
public class Student {

    @Id // id is taken as primary key 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // id is generated automatically by this 
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)  // lastName variable is mapped to last_name column in database
    private String lastName;



}
