package sa.aref.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.aref.university.entity.Professor;

@Repository
public interface ProffessorRepository extends JpaRepository<Professor, Long> {
}
