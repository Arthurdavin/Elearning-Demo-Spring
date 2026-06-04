package co.istad.elearningcodejourney.dto.category.categoryrequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 50,message = "Name must not exceed 50 characters")
        String name,
        @NotBlank(message = "icon is required")
        String icon
) {
}
