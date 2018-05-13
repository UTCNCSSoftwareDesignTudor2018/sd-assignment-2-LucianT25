package com.utcn.UTCN.Student.Platform.service;

import com.utcn.UTCN.Student.Platform.persistence.model.Enrollment;
import com.utcn.UTCN.Student.Platform.persistence.model.Report;
import com.utcn.UTCN.Student.Platform.persistence.model.ReportToGenerate;
import com.utcn.UTCN.Student.Platform.persistence.model.Student;
import com.utcn.UTCN.Student.Platform.persistence.repository.ReportRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReportService {
    @Inject
    ReportRepository reportRepository;

    @Inject
    EnrollmentService enrollmentService;

    @Inject
    StudentService studentService;

    public void createReport(ReportToGenerate reportToGenerate) {
        Student student = studentService.getStudent(reportToGenerate.getStudentId());
        List<Enrollment> enrollments = enrollmentService.getStudentEnrollmentsByYear(
                reportToGenerate.getStudentId(), reportToGenerate.getYear());

        Report report = new Report(student, enrollments);

        reportRepository.save(report);
    }
}
