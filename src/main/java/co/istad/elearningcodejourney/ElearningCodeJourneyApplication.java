package co.istad.elearningcodejourney;

import co.istad.elearningcodejourney.feature.course.Course;
import co.istad.elearningcodejourney.feature.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing

@SpringBootApplication
public class ElearningCodeJourneyApplication implements CommandLineRunner {

    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(ElearningCodeJourneyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Course> courses = courseRepository.allCourses();
        Course course = courseRepository.byId(2);
        IO.print(course.getTitle());

    }
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
