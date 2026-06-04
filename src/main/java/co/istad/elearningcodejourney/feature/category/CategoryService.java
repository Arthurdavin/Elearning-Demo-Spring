package co.istad.elearningcodejourney.feature.category;

import co.istad.elearningcodejourney.dto.category.categoryrequest.CreateCategoryRequest;
import co.istad.elearningcodejourney.dto.category.categoryrequest.UpdateCategoryRequest;
import co.istad.elearningcodejourney.dto.category.categoryresponse.CategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryResponse> getAllCategory(Integer page, Integer size);
    CategoryResponse getCategoryById(Integer id);
    CategoryResponse createCategory(CreateCategoryRequest request);
    CategoryResponse updateCategoryById(Integer id, UpdateCategoryRequest request);
    void deleteCategoryById(Integer id);
}
