package co.istad.elearningcodejourney.feature.course;

import co.istad.elearningcodejourney.feature.course.dto.CourseResponse;
import co.istad.elearningcodejourney.feature.course.dto.CreateCourseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseResponse createCourse(
            @Valid @RequestBody CreateCourseRequest createCourseRequest,
            @AuthenticationPrincipal Jwt jwt
            ){
        IO.print("Jwt: "+ jwt.getSubject());
        return courseService.createCourse(createCourseRequest,jwt);
    }

    @GetMapping
    public Page<CourseResponse> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return courseService.getAllCourses(page,size);
    }

    @GetMapping("/{slug}")
    public  CourseResponse getCourseBySlug(@PathVariable String slug){
        return courseService.getCourseBySlug(slug);
    }

    @DeleteMapping("/{slug}")
    public void deleteCourse(@PathVariable String slug){
        courseService.deleteCourse(slug);
    }

    @PutMapping("/{slug}/publish")
    public CourseResponse togglePublish(@PathVariable String slug){
        return courseService.togglePublish(slug);
    }
}
