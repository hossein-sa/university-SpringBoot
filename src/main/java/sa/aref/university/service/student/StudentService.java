package sa.aref.university.service.student;

import sa.aref.university.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    void enrollStudent(Long studentId, Long courseId);
    void dropStudent(Long studentId, Long courseId);
}
