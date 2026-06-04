package co.istad.elearningcodejourney.dto.category.categoryrequest;

import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(
        @Size(max = 50,message = "Name must not exceed 50 characters")
        String name,
        String icon
) {
}
