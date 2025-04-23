package com.project2.worklet.jobPostingService;

import com.project2.worklet.command.JobPostingVO2;

import java.util.List;

public interface JobPostingService {
    public int selectSeqMax(); //db에서 저장된 채용공고의 seq중 가장큰값 가져옴
    public String postList();//매일 정해진 시간에 채용공고 api 50개씩 불러와서 db에 저장
    public int postDetail(List<String> list);
}
