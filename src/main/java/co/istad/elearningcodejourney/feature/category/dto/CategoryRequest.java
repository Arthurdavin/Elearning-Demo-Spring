package co.istad.elearningcodejourney.feature.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 50,message = "Name must not exceed 50 characters")
        String name,
        @NotBlank(message = "iconis required")
        String icon
) {
}
