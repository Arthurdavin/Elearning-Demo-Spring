package co.istad.elearningcodejourney.feature.instructor;

import co.istad.elearningcodejourney.feature.course.Course;
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
@Table(name = "instructor_profile")
public class InstructorProfile {

    public InstructorProfile(String userid){
        this.userid=userid;
    }

    @Id
    private String userid;

    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "instructorProfile")
    private List<Course> courses;
}
