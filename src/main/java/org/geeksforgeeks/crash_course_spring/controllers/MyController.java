package org.geeksforgeeks.crash_course_spring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/add_two_numbers")
    public int addTwoNumbers(
            @RequestParam int a,
            @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/mul_two_numbers")
    public int mulTwoNumbers(
            @RequestParam int a,
            @RequestParam int b) {
        return a * b;
    }

}
