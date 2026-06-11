package co.istad.elearningcodejourney.feature.category;

import co.istad.elearningcodejourney.config.auditing.BasedEntity;
import co.istad.elearningcodejourney.feature.course.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BasedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50,nullable = false,unique = true)

    private String name;
    private String Icon;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDeleted = false;
    @OneToMany(mappedBy = "category")
    private List<Course> courses;
}
