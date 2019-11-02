package edu.mum.sodminiproj1.batch;

import edu.mum.sodminiproj1.model.Student;
import edu.mum.sodminiproj1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Student> {

    @Autowired
    StudentService studentService;

    @Override
    public void write(List<? extends Student> students) throws Exception {

        System.out.println("Data saved for students = " + students);

        studentService.saveStudents(students);

    }
}
