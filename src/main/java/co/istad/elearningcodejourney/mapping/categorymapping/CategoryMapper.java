package co.istad.elearningcodejourney.mapping.categorymapping;

import co.istad.elearningcodejourney.dto.category.categoryrequest.CategoryRequest;
import co.istad.elearningcodejourney.dto.category.categoryrequest.CreateCategoryRequest;
import co.istad.elearningcodejourney.dto.category.categoryresponse.CategoryResponse;
import co.istad.elearningcodejourney.feature.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CreateCategoryRequest request){
        Category category = new Category();
        category.setName(request.name());
        category.setIcon(request.icon());
        category.setIsDelete(false);
        return category;
    }
    public CategoryResponse toResponse(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getIcon()
        );
    }
    public void updateEntity(Category category, CategoryRequest request){
        category.setName(request.name());
        category.setIcon(request.icon());
    }
}
