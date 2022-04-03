package ru.surantaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.surantaev.dao.CourseDao;
import ru.surantaev.entity.Course;

import java.util.List;

@Service
@Transactional
public class CourseServiceImplement implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDao.deleteCourse(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        courseDao.updateCourse(course, id);
    }

    @Override
    public List<Course> getCoursesById(Long id) {
        return courseDao.getCoursesById(id);
    }
}
