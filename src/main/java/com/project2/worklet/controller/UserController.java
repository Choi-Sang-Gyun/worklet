package com.project2.worklet.controller;


import com.project2.worklet.command.UserVO;
import com.project2.worklet.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @GetMapping("/regist")
    public String showRegistForm() {
        return "User/regist";  // 회원가입 폼을 보여줌
    }

    @PostMapping("/regist")
    public String regist(UserVO user, @RequestParam("wantJobType") String[] wantJobTypes) {

        log.info( user.toString() );

        user.setWantJobType1(wantJobTypes.length > 0 ? wantJobTypes[0] : null);
        user.setWantJobType2(wantJobTypes.length > 1 ? wantJobTypes[1] : null);
        user.setWantJobType3(wantJobTypes.length > 2 ? wantJobTypes[2] : null);

        int result = userService.insertUser(user);
        if(result == 1) {
            log.info( user.toString() );
        } else {
            log.info( "실패");
        }

        return "redirect:/user/login";  // 로그인 페이지로 리다이렉트
    }
    @GetMapping("/login")
    public String login() {
        return "User/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String userPw,
                        Model model,
                        HttpSession session) {


        // paramMap 만들어서 서비스로 전달
        Map<String, String> paramMap = Map.of(
                "userId", userId,
                "userPw", userPw
        );

        // 서비스 호출
        UserVO user = userService.loginUser(paramMap);

        if (user != null) {
            model.addAttribute("user", user);
            session.setAttribute("loginUser", user);
            System.out.println(">>> login – session: " + session.getId());
            System.out.println(">>> loginUser: " + session.getAttribute("loginUser"));
            return "redirect:/Board/mainPage";// 로그인 성공 시
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "User/login"; // 실패 시
        }
    }


    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {

        UserVO loginUser = (UserVO) session.getAttribute("loginUser");

        if(loginUser != null) {

            UserVO fullUser = userService.getUserById(loginUser.getUserId());

            List<String> wantJobTypes = new ArrayList<>();
            if (fullUser.getWantJobType1() != null) wantJobTypes.add(fullUser.getWantJobType1());
            if (fullUser.getWantJobType2() != null) wantJobTypes.add(fullUser.getWantJobType2());
            if (fullUser.getWantJobType3() != null) wantJobTypes.add(fullUser.getWantJobType3());
            fullUser.setWantJobType(wantJobTypes.toArray(new String[0]));

            model.addAttribute("userVO", fullUser);
            return "User/mypage";
        }else {
            return "redirect:/user/login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/Board/mainPage"; // 홈페이지로 리다이렉트
    }

    @GetMapping("/resume")
    public String resume() {
        return "User/resume";
    }


    @GetMapping("/id")
    public String id() {
        return "User/id";
    }

    @GetMapping("/pw")
    public String pw() {
        return "User/pw";
    }
}
