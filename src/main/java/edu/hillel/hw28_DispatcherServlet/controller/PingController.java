package edu.hillel.hw28_DispatcherServlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String testPing() {
        return "OK";
    }
}
