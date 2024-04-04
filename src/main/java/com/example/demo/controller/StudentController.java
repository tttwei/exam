package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class StudentController {
    public String[] s = new String[]{"星期一买枪","星期二买头套","星期三偷车","星期四抢银行"};
    @GetMapping("")
    public String get(){

        return "hello";
    }
}
