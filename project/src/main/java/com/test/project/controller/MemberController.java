package com.test.project.controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MemberController {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webDB";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "1234";

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }
    
    @PostMapping("/Mainlogin")
    public String login(@RequestParam("id") String id,
                        @RequestParam("passwd") String passwd,
                        RedirectAttributes redirectAttributes,
                        HttpServletRequest request) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String query = "SELECT * FROM members WHERE id = ? AND passwd = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.setString(2, passwd);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        String name = resultSet.getString("name");

                        HttpSession session = request.getSession(); // 로그인 성공 시 세션 세팅
                        session.setAttribute("id", id);
                        session.setAttribute("name", name);
                        return "redirect:/main";
                    } else {
                        // 로그인 실패 메시지 추가
                        redirectAttributes.addFlashAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다.");
                        // 로그인 페이지로 리다이렉트
                        return "redirect:/Mainlogin";
                    }
                } 
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 로그인 실패시, 다시 로그인 페이지로
        return "redirect:/Mainlogin";
    }

    @GetMapping("/Mainlogin")
    public String getMainLogin() {
        return "Mainlogin";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }
    

    @PostMapping("/register")
    public String postRegister(@RequestParam("id") String id,
                                @RequestParam("passwd") String passwd,
                                @RequestParam("name") String name,
                                RedirectAttributes redirectAttributes,
                                 HttpServletRequest request) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String query = "SELECT * FROM members WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        // 사용자가 이미 존재하는 아이디이다.
                        redirectAttributes.addFlashAttribute("registerError", "이미 존재하는 아이디");
                        return "redirect:/register"; // 다시 회원가입 페이지로 돌아가기
                    } else {
                        query = "INSERT INTO members (id, passwd, name) VALUES (?, ?, ?)";
                        try (PreparedStatement statement2 = connection.prepareStatement(query)) {
                            statement2.setString(1, id);
                            statement2.setString(2, passwd);
                            statement2.setString(3, name);

                            int num = statement2.executeUpdate();
                            if (num > 0) {
                                return "redirect:/register_success";
                            } else {
                                redirectAttributes.addFlashAttribute("registerError", "서버 오류");
                                return "redirect:/register";
                            }
                        }
                    }
                } 
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("registerError", "서버 오류");
            return "redirect:/register";
        }
    }
    
    @GetMapping("/register_success")
    public String getRegisterSuccess() {
        return "register_success";
    }
}
