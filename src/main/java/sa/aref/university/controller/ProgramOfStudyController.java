package sa.aref.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.aref.university.entity.ProgramOfStudy;
import sa.aref.university.service.program_of_study.ProgramOfStudyService;
import sa.aref.university.service.program_of_study.ProgramOfStudyServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/programs-of-study")
public class ProgramOfStudyController {

    private final ProgramOfStudyService programOfStudyService;

    public ProgramOfStudyController(ProgramOfStudyService programOfStudyService) {
        this.programOfStudyService = programOfStudyService;
    }

    @GetMapping("/all")
    public List<ProgramOfStudy> getAllProgramsOfStudy() {
        return programOfStudyService.getAllProgramsOfStudy();
    }

    @PostMapping("/add")
    public ProgramOfStudy addProgramOfStudy(@Valid @RequestBody ProgramOfStudy programOfStudy) {
        return programOfStudyService.addProgramOfStudy(programOfStudy);
    }

    @GetMapping("/{id}")
    public ProgramOfStudy getProgramOfStudyById(@PathVariable Long id) {
        return programOfStudyService.getProgramOfStudyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProgramOfStudyById(@PathVariable Long id) {
        boolean isDeleted = programOfStudyService.deleteProgramOfStudy(id);
        if (isDeleted) {
            return ResponseEntity.ok("Program of study with ID " + id + " has been deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Program of study with ID " + id + " was not found");
        }
    }



}
