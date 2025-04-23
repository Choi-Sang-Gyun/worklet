package com.project2.worklet.controller;

import com.project2.worklet.command.QnaVO;
import com.project2.worklet.qna.service.QnaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class QnaController {

    private final QnaService qnaService;

    public QnaController(QnaService qnaService) {
        this.qnaService = qnaService;
    }

    @GetMapping("/qna_list")
    public String qna_list() {
        return "Board/qna_list";
    }

    @GetMapping("/qna_reply")
    public String qna_reply() {
        return "Board/qna_reply";
    }

    @GetMapping("/qna_write")
    public String qna_write() {
        return "Board/qna_write";
    }


    @PostMapping("/qnaForm")
    public String qnaForm(QnaVO vo) {
        qnaService.qnaForm(vo);
        return "redirect:/qna/qna_list";
    }

}
