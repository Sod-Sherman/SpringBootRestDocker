package edu.mum.sodminiproj1.batch;

import edu.mum.sodminiproj1.model.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        student.setTime(LocalDateTime.now());
        return student;
    }
}
