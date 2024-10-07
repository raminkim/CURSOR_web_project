package com.test.project.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.project.model.LoginBean;
@Controller
public class MyController {
    @GetMapping("/mvc")
    @PostMapping("/mvc")
    public String loginForm() {
        return "mvc";
    }
}
