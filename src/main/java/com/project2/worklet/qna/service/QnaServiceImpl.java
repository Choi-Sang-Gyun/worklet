package com.project2.worklet.qna.service;


import com.project2.worklet.command.QnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {

    @Autowired
    private QnaMapper qnaMapper;


    @Override
    public int qnaForm(QnaVO vo) {
        return qnaMapper.qnaForm(vo);
    }
}

