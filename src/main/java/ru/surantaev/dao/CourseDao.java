package ru.surantaev.dao;

import ru.surantaev.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourse();
    List<Course> getCoursesById(Long id);
    void saveCourse(Course course);
    void deleteCourse(Long id);
    Course getCourseById(Long id);
    void updateCourse(Course course, Long id);
}
