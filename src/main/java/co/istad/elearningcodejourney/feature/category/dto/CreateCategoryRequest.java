package co.istad.elearningcodejourney.feature.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(
    @NotBlank(message = "Category Name is required")
    @Size(min = 2,max = 250,message = "Name must not exceed 50 characters")
    String name,
    @NotNull(message = "Status isDeleted is required")
    Boolean isDeleted
) {
}
