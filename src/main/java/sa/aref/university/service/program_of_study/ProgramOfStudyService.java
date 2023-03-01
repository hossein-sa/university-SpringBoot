package sa.aref.university.service.program_of_study;

import sa.aref.university.entity.ProgramOfStudy;

import java.util.List;

public interface ProgramOfStudyService {
    ProgramOfStudy addProgramOfStudy(ProgramOfStudy programOfStudy);
    ProgramOfStudy getProgramOfStudyById(Long id);
    boolean deleteProgramOfStudy(Long id);
    ProgramOfStudy updateProgramOfStudy(Long id,ProgramOfStudy programOfStudy);

    List<ProgramOfStudy> getAllProgramsOfStudy();


}
