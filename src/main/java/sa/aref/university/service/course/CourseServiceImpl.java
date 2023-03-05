package sa.aref.university.service.course;

import org.springframework.stereotype.Service;
import sa.aref.university.entity.Course;
import sa.aref.university.exception.CustomExceptionNotFound;
import sa.aref.university.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CustomExceptionNotFound("Course not found"));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new CustomExceptionNotFound("Course not found"));
        existingCourse.setCode(course.getCode());
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setCreditHours(course.getCreditHours());
        existingCourse.setProgramOfStudy(course.getProgramOfStudy());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new CustomExceptionNotFound("Course not found"));
        courseRepository.delete(existingCourse);
    }
}
