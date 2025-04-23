package com.project2.worklet.qna.service;

import com.project2.worklet.command.NoticeVO;
import com.project2.worklet.command.QnaVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QnaMapper {
    int qnaForm(QnaVO vo);
}
