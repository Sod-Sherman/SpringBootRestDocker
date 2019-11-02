package edu.mum.sodminiproj1.batch;

import edu.mum.sodminiproj1.model.Student;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;

public class StudentFieldSetMapper implements FieldSetMapper<Student> {
    @Override
    public Student mapFieldSet(FieldSet fieldSet) throws BindException {

        if(fieldSet == null) return null;

        Student student = new Student();
        student.setId(fieldSet.readLong("id"));
        student.setFirstName(fieldSet.readString("firstName"));
        student.setLastName(fieldSet.readRawString("lastName"));
        student.setGPA(fieldSet.readDouble("gpa"));
        student.setDob(LocalDate.of(LocalDate.now().getYear()-fieldSet.readInt("age"), 1,1));

        System.out.println(String.format("Converted from age [%d] to birth date [%s] in StudentFieldSetMapper: ",
                fieldSet.readInt(3), student.getDob().toString()));

        return student;
    }
}
