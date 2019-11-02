package edu.mum.sodminiproj1.service;

import edu.mum.sodminiproj1.model.Student;
import edu.mum.sodminiproj1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void saveStudent(Student student) {

        for(Student s: getAllStudents()){
            if(!s.equals(student))
                studentRepository.save(student);
        }

    }

    @Override
    public void saveStudents(List<? extends Student> students) {
        studentRepository.saveAll(students);

    }
}
