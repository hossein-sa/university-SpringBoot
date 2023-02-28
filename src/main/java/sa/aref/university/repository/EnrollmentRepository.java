package sa.aref.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.aref.university.entity.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
