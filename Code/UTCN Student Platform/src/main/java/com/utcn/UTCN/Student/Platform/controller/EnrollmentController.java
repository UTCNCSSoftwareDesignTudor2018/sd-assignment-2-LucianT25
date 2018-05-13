package com.utcn.UTCN.Student.Platform.controller;

import com.google.gson.Gson;
import com.utcn.UTCN.Student.Platform.persistence.model.Enrollment;
import com.utcn.UTCN.Student.Platform.persistence.model.ToEnroll;
import com.utcn.UTCN.Student.Platform.persistence.model.EnrollmentToUpdate;
import com.utcn.UTCN.Student.Platform.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Inject
    EnrollmentService enrollmentService;

    @RequestMapping(value="/getStudentEnrollments", method = RequestMethod.GET)
    List<Enrollment> getStudentEnrollments(@RequestParam int studentId) {
        return enrollmentService.getStudentEnrollments(studentId);
    }

    @RequestMapping(value="/getTeacherEnrollments", method = RequestMethod.GET)
    List<Enrollment> getTeacherEnrollments(@RequestParam int teacherId) {
        return enrollmentService.getTeacherEnrollments(teacherId);
    }

    @RequestMapping(value="/enroll", method = RequestMethod.POST)
    void enroll(@RequestBody String toEnroll) {
        Gson gson = new Gson();
        ToEnroll toEnrollObj = gson.fromJson(toEnroll, ToEnroll.class);

        enrollmentService.enroll(toEnrollObj.getCourseId(), toEnrollObj.getStudentId());
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    void updateEnrollment(@RequestBody String toUpdate) {
        Gson gson = new Gson();
        EnrollmentToUpdate enrollmentToUpdateObj = gson.fromJson(toUpdate, EnrollmentToUpdate.class);

        enrollmentService.update(enrollmentToUpdateObj);
    }

}


