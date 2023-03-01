package sa.aref.university.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.aref.university.entity.ProgramOfStudy;
import sa.aref.university.service.program_of_study.ProgramOfStudyServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/programs")
public class ProgramOfStudyController {
    private final ProgramOfStudyServiceImpl programOfStudyService;

    public ProgramOfStudyController(ProgramOfStudyServiceImpl programOfStudyService) {
        this.programOfStudyService = programOfStudyService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProgramOfStudy> addProgramOfStudy(@RequestBody @Valid ProgramOfStudy programOfStudy) {
        ProgramOfStudy createdProgramOfStudy = programOfStudyService.addProgramOfStudy(programOfStudy);
        return new ResponseEntity<>(createdProgramOfStudy, HttpStatus.CREATED);
    }
}
