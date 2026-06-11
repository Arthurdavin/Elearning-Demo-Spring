package co.istad.elearningcodejourney.feature.course;


import co.istad.elearningcodejourney.feature.course.dto.CourseResponse;
import co.istad.elearningcodejourney.feature.course.dto.CreateCourseRequest;
import co.istad.elearningcodejourney.feature.course.dto.UpdateCourseRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course mapCreateCourseRequestToCourse(CreateCourseRequest createCourseRequest);
    CourseResponse mapCourseToCourseResponse(Course course);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourseFromRequest(UpdateCourseRequest request, @MappingTarget Course course);
}
