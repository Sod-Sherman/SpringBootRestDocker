package edu.mum.sodminiproj1.controller;

import edu.mum.sodminiproj1.model.Student;
import edu.mum.sodminiproj1.service.StudentService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public String addNewStudent(Student student){
        System.out.println("Adding new student from Post mapping = " + student);
        studentService.saveStudent(student);
        return "Saved";
    }

//======================= Batching section start=====================================
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/load")@PostMapping("/load")
    public @ResponseBody Iterable<Student> loadFile() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("jobExecution .getStatus() = " + jobExecution.getStatus());
        System.out.println("Batch is Running!...................................");

        while (jobExecution.isRunning()){
            System.out.print("... ");
        }
//        return jobExecution.getStatus().toString();
        return studentService.getAllStudents();

    }

    @GetMapping("/forbidden403")@PostMapping("/forbidden403")
    public String showError403(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Forbidden</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Forbidden to access this section</h1>\n" +
                "<h2>Sorry! Your permission does not enough to reach it.</h2>\n" +
                "<h3>Logout and Login to admin role</h3>\n" +
                "<a href=\"/\">HOME</a><p>\n" +
                "<a href=\"/logout\">Logout</a>\n" +
                "</body>\n" +
                "</html>";
    }
}
