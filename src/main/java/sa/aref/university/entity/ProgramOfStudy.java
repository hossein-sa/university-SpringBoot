package sa.aref.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProgramOfStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "programsOfStudy")
    private List<Student> students;

    @OneToMany(mappedBy = "programOfStudy")
    private List<Course> courses;
}
