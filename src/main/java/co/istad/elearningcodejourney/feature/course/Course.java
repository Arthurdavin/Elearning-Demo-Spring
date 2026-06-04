package co.istad.elearningcodejourney.feature.course;

import co.istad.elearningcodejourney.feature.category.Category;
import co.istad.elearningcodejourney.feature.enrollment.Enrollment;
import co.istad.elearningcodejourney.feature.instructor.InstructorProfile;
import co.istad.elearningcodejourney.feature.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String keyword;
    private String title;
    private String description;
    private String thumbnail;
    private Float starRating;
    private Integer countRating;
    private Float totalHours;
    private String level;
    private BigDecimal price;
    private Float discountPercent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "course")
    private List<Video> video;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorProfile instructorProfile;
    private Boolean isPublished;
    private Boolean isDeleted;
}