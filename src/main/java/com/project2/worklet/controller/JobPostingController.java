package com.project2.worklet.controller;

import com.project2.worklet.jobPostingService.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPostingController {

    @Autowired
    @Qualifier("JobPosting")
    private JobPostingService jobPostingService;


    @GetMapping("/JobPosting")
    public String jobPosting() {
        return "JobPosting";
    }

}
