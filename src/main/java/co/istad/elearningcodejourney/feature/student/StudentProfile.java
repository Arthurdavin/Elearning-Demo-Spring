package co.istad.elearningcodejourney.feature.student;

import co.istad.elearningcodejourney.config.auditing.BasedEntity;
import co.istad.elearningcodejourney.feature.enrollment.Enrollment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_profile")

public class StudentProfile extends BasedEntity {
    @Id
    private String userid;

    private String major;
    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "studentProfile")
    private List<Enrollment> enrollments;
}
