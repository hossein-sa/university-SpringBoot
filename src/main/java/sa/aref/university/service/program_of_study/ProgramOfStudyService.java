package sa.aref.university.service.program_of_study;

import sa.aref.university.entity.ProgramOfStudy;

import java.util.List;

public interface ProgramOfStudyService {
    ProgramOfStudy addProgramOfStudy(ProgramOfStudy programOfStudy);
    List<ProgramOfStudy> getAllProgramOfStudy();
    ProgramOfStudy getProgramOfStudyById(Long id);
    void deleteProgramOfStudy(Long id);
    ProgramOfStudy updateProgramOfStudy(Long id,ProgramOfStudy programOfStudy);
 }
