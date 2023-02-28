package sa.aref.university.service.student;

import org.springframework.stereotype.Service;
import sa.aref.university.entity.Course;
import sa.aref.university.entity.Enrollment;
import sa.aref.university.entity.Student;
import sa.aref.university.exception.CustomExceptionIsExist;
import sa.aref.university.exception.CustomExceptionNotFound;
import sa.aref.university.repository.CourseRepository;
import sa.aref.university.repository.EnrollmentRepository;
import sa.aref.university.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new CustomExceptionNotFound("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new CustomExceptionNotFound("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CustomExceptionNotFound("Course not found with id: " + courseId));
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (existingEnrollment.isPresent()) {
            throw new CustomExceptionIsExist("Student is already enrolled in the course");
        } else {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollmentRepository.save(enrollment);
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void dropStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new CustomExceptionNotFound("Student not found with id: " + studentId));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CustomExceptionNotFound("Course not found with id: " + courseId));
        Enrollment enrollment = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId).orElseThrow(() -> new CustomExceptionNotFound("Student is not enrolled in the course"));
        enrollmentRepository.delete(enrollment);
    }

}
