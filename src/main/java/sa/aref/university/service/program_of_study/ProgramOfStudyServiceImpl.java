package sa.aref.university.service.program_of_study;

import org.springframework.stereotype.Service;
import sa.aref.university.entity.ProgramOfStudy;
import sa.aref.university.exception.CustomExceptionNotFound;
import sa.aref.university.repository.ProgramOfStudyRepository;

import java.util.List;

@Service
public class ProgramOfStudyServiceImpl implements ProgramOfStudyService {
    private final ProgramOfStudyRepository programOfStudyRepository;

    public ProgramOfStudyServiceImpl(ProgramOfStudyRepository programOfStudyRepository) {
        this.programOfStudyRepository = programOfStudyRepository;
    }

    @Override
    public ProgramOfStudy addProgramOfStudy(ProgramOfStudy programOfStudy) {
        return programOfStudyRepository.save(programOfStudy);
    }

    @Override
    public ProgramOfStudy getProgramOfStudyById(Long id) {
        return programOfStudyRepository.findById(id).orElseThrow(() -> new CustomExceptionNotFound("Program of Study not found"));
    }

    @Override
    public void deleteProgramOfStudy(Long id) {
        ProgramOfStudy programOfStudy = programOfStudyRepository.findById(id).orElseThrow(() -> new CustomExceptionNotFound("Program of Study not found"));
        programOfStudyRepository.delete(programOfStudy);

    }

    @Override
    public ProgramOfStudy updateProgramOfStudy(Long id, ProgramOfStudy programOfStudy) {
        ProgramOfStudy existingProgramStudy = programOfStudyRepository.findById(id).orElseThrow(() -> new CustomExceptionNotFound("Program of Study not found"));
        existingProgramStudy.setName(programOfStudy.getName());
        return programOfStudyRepository.save(existingProgramStudy);
    }

    @Override
    public List<ProgramOfStudy> getAllProgramsOfStudy() {
        return programOfStudyRepository.findAll();
    }
}
