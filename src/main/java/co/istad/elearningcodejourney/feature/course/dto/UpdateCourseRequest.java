package co.istad.elearningcodejourney.feature.course.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record UpdateCourseRequest(
        @Size(max = 255)
        String keyword,
        @Size(max = 255)
        String title,
        String description,
        @Size(max = 255)
        String thumbnail,
        @Positive
        @Max(50)
        Float totalHours,
        @Size(max = 50)
        String level,
        @Positive
        BigDecimal price,
        @Min(0)
        Float discountPercent,
        Integer categoryId
) {}