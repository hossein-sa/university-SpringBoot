package sa.aref.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String description;
    private int creditHours;

    @ManyToOne
    @JoinColumn(name = "program_of_study_id", referencedColumnName = "id")
    private ProgramOfStudy programOfStudy;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
