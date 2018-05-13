package com.utcn.UTCN.Student.Platform.controller;

import com.google.gson.Gson;
import com.utcn.UTCN.Student.Platform.persistence.model.Student;
import com.utcn.UTCN.Student.Platform.persistence.model.StudentToUpdate;
import com.utcn.UTCN.Student.Platform.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Inject
    StudentService studentService;

    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    Student getStudent(@RequestParam int studentId) {
        return studentService.getStudent(studentId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    void update(@RequestBody String studentToUpdate) {
        Gson gson = new Gson();
        StudentToUpdate studentToUpdateObj = gson.fromJson(studentToUpdate, StudentToUpdate.class);


    }


}
