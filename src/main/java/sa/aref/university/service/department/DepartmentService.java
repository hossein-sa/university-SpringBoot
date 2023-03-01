package sa.aref.university.service.department;

import sa.aref.university.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department getDepartmentById(Long id);

    Department updateDepartment(Department department);

    void deleteDepartmentById(Long id);
}
