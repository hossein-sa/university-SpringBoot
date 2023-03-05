package sa.aref.university.service.course;

import sa.aref.university.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long courseId,Course course);
    void deleteCourse(Long courseId);
}
