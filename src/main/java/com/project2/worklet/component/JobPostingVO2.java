package com.project2.worklet.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobPostingVO2 {

    private int jpno;
    private int empSeqno;
    private String empWantedTitle;
    private String empBusiNm;
    private String empWantedStdt;
    private String empWantedEndt;
    private String empWantedTypeNm;
    private String regLogImgNm;
    private String empWantedHomepgDetail;
}
