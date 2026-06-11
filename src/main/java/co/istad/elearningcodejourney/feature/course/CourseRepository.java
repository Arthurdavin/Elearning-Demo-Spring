package co.istad.elearningcodejourney.feature.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    boolean existsBySlug(String slug);
    Optional<Course> findBySlugAndIsDeletedFalse(String slug);
    Page<Course> findAllByIsDeletedFalse(Pageable pageable);

    List<Course> allCourses();
    Course byId(Integer id);
}