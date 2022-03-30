package ru.surantaev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course/{id}")
public class CourseController {

    @GetMapping
    public String course(@PathVariable Long id) {

        return null;
    }
}
