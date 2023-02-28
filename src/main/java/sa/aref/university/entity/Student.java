package sa.aref.university.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends Person {
    private String programOfStudy;


}
