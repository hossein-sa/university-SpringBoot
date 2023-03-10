package sa.aref.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sa.aref.university.entity.ProgramOfStudy;

@Repository
public interface ProgramOfStudyRepository extends JpaRepository<ProgramOfStudy, Long> {
}
