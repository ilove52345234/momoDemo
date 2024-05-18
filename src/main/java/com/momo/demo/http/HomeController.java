package com.momo.demo.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首頁
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
