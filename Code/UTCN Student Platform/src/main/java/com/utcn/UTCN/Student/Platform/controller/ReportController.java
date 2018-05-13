package com.utcn.UTCN.Student.Platform.controller;

import com.google.gson.Gson;
import com.utcn.UTCN.Student.Platform.persistence.model.Report;
import com.utcn.UTCN.Student.Platform.persistence.model.ReportToGenerate;
import com.utcn.UTCN.Student.Platform.service.ReportService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Inject
    ReportService reportService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    void createReport(@RequestBody String reportToGenerate) {
        Gson gson = new Gson();
        ReportToGenerate reportToGenerateObj = gson.fromJson(reportToGenerate, ReportToGenerate.class);

        reportService.createReport(reportToGenerateObj);
    }

}
