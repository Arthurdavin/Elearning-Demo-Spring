package co.istad.elearningcodejourney.feature.course;

import co.istad.elearningcodejourney.feature.course.dto.CourseResponse;
import co.istad.elearningcodejourney.feature.course.dto.CreateCourseRequest;
import co.istad.elearningcodejourney.feature.course.dto.UpdateCourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CourseService {
    CourseResponse createCourse(CreateCourseRequest createCourseRequest);
    Page<CourseResponse> getAllCourses(int page, int size);
    CourseResponse getCourseBySlug(String slug);
    CourseResponse updateCourse(String slug, UpdateCourseRequest request);
    void deleteCourse(String slug);
    CourseResponse togglePublish(String slug);
}
