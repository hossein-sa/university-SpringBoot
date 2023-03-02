package sa.aref.university.service.department;

import org.springframework.stereotype.Service;
import sa.aref.university.entity.Department;
import sa.aref.university.exception.CustomExceptionNotFound;
import sa.aref.university.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new CustomExceptionNotFound("Department not found"));
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
            existingDepartment.setDescription(department.getDescription());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
