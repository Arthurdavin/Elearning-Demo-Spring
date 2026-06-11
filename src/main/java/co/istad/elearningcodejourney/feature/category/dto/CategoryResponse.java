package co.istad.elearningcodejourney.feature.category.dto;

public record CategoryResponse(
        Integer id,
        String name,
        Boolean isDeleted
) {
}
