package com.project2.worklet.jobPostingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("JobPosting")
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingMapper jobPostingMapper;
}
