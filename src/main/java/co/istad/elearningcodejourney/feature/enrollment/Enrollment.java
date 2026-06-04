package co.istad.elearningcodejourney.feature.enrollment;

import co.istad.elearningcodejourney.feature.course.Course;
import co.istad.elearningcodejourney.feature.student.StudentProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Boolean paymentStatus;
    private String paymentMethod;
    private LocalDateTime paymentAt;
    private LocalDateTime enrolledAt;
}
