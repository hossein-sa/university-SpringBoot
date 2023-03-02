package sa.aref.university.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.aref.university.entity.Department;
import sa.aref.university.service.department.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDepartment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
        boolean isDeleted = departmentService.deleteDepartmentById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Department wit ID " + id + " has been deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department with ID " + id + " was not found");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        Department updatedDepartment = departmentService.updateDepartment(department);
        String successMessage = "Department with ID " + id + " has been updated successfully";
        return ResponseEntity.ok().body(successMessage);
    }




}
