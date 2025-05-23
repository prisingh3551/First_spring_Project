package com.priya.First_spring_Project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.First_spring_Project.entities.Student;
import com.priya.First_spring_Project.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;  // final cannot be without value

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        Student addedStudent = this.studentRepository.save(student);
        return addedStudent;
    }

    public Student getStudentById(long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);  // this might not have a value.
        return optionalValue.orElse(null);

        // if(optionalValue.isEmpty()) return null;
        // return optionalValue.get();
    }

    public Student updateStudent(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        // student does not exist
        if(existingStudent == null) {
            return null;
        }

        // this.studentRepository.save(student); -- this will throw an error because student already exist with id so the db will think we are trying to create another instance with the same id 
        
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }
}
