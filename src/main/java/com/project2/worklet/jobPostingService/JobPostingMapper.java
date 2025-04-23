package com.project2.worklet.jobPostingService;


import com.project2.worklet.command.JobPostingDetailVO;
import com.project2.worklet.command.JobPostingVO2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface JobPostingMapper {
    public int selectSeqMax();
    public int postList(List<JobPostingVO2> list);
    public int postDetail(List<JobPostingDetailVO> list);
}
