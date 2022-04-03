package ru.surantaev.dao;

import org.springframework.stereotype.Repository;
import ru.surantaev.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseImplement implements CourseDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAllCourse() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public List<Course> getCoursesById(Long id) {
        return entityManager.createQuery("SELECT c FROM Course c where c.company.id=:id").setParameter("id", id).getResultList();
    }

    @Override
    public void saveCourse(Course course) {
        Long id = course.getId();
        if (id == null) {
            entityManager.persist(course);
        }else {
            entityManager.merge(course);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        entityManager.remove(getCourseById(id));
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Course course1 = getCourseById(id);
        course1.setCourseName(course.getCourseName());
        entityManager.merge(course1);
    }
}
