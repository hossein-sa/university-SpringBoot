package sa.aref.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.aref.university.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
