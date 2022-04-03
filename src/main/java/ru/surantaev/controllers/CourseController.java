package ru.surantaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.surantaev.entity.Company;
import ru.surantaev.entity.Course;
import ru.surantaev.entity.Teacher;
import ru.surantaev.service.CompanyService;
import ru.surantaev.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping("/allCourse")
    public String getAllCourse(Model model) {
        List<Course> getAllCourse = courseService.getAllCourse();
        model.addAttribute("allCourses", getAllCourse);
        return "course/course-page";
    }

    @GetMapping("/{id}")
    public String getCourses(@PathVariable Long id, Model model, Course course) {
        model.addAttribute("courses1", courseService.getCoursesById(id));
        return "course/course-id";
    }

    @GetMapping("/course-create")
    public String creatCourseForm(Course course, Model model) {
        model.addAttribute("course", course);
        return "course/course-create";
    }

    @PostMapping("/course-save")
    public String createCourse(@ModelAttribute("course") Course course, @PathVariable Long id) {
        course.setCompany(companyService.getCompanyById(id));
        courseService.saveCourse(course);
        return "redirect:/course/allCourse";
    }
}
