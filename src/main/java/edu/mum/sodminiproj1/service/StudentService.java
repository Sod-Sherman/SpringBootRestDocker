package edu.mum.sodminiproj1.service;

import edu.mum.sodminiproj1.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    abstract public Iterable<Student> getAllStudents();
    abstract public Student getStudentById(Long id);
    abstract public void saveStudent(Student student);
    abstract public void saveStudents(List<? extends Student> students);
}
