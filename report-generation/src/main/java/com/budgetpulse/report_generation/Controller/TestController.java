package com.budgetpulse.report_generation.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/some-endpoint")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Hello from the backend!");
    }
}

