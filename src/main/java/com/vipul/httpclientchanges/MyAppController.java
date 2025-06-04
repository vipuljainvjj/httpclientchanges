package com.vipul.httpclientchanges;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyAppController {

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> getHome(HttpServletRequest request) {
        return ResponseEntity.ok("Home");
    }

}
