package sa.aref.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.aref.university.entity.Enrollment;
import sa.aref.university.entity.Student;
import sa.aref.university.exception.CustomExceptionNotFound;
import sa.aref.university.service.student.StudentService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.created(URI.create("/api/students/" + savedStudent.getId())).body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long id,
                                                 @Valid @RequestBody Student updatedStudent)
            throws CustomExceptionNotFound {
        Student student = studentService.getStudentById(id);
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourses(updatedStudent.getCourses());
        student.setProgramsOfStudy(updatedStudent.getProgramsOfStudy());
        Student updated = studentService.updateStudent(student);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/enroll")
    public ResponseEntity<Void> enrollStudent(@PathVariable Long studentId, @RequestParam Long courseId)
            throws CustomExceptionNotFound {
        studentService.enrollStudent(studentId, courseId);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{studentId}/enrollments/{courseId}")
    public void dropStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.dropStudent(studentId, courseId);
    }
}
