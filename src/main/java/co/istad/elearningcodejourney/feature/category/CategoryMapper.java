package co.istad.elearningcodejourney.feature.category;

import co.istad.elearningcodejourney.feature.category.dto.CategoryResponse;
import co.istad.elearningcodejourney.feature.category.dto.CreateCategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryRequestToCategory(CreateCategoryRequest categoryRequest);
    CategoryResponse categoryToCategoryResponse(Category category);
}
