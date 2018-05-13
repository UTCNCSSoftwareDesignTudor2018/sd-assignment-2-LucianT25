package com.utcn.UTCN.Student.Platform.persistence.repository;

import com.utcn.UTCN.Student.Platform.persistence.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReportRepository extends MongoRepository<Report, String> {
    public List<Report> findByStudentId();
}
