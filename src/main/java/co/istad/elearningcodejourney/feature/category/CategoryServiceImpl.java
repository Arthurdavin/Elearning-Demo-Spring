package co.istad.elearningcodejourney.feature.category;

import co.istad.elearningcodejourney.dto.request.categoryrequest.CreateCategoryRequest;
import co.istad.elearningcodejourney.dto.request.categoryrequest.UpdateCategoryRequest;
import co.istad.elearningcodejourney.dto.response.categoryresponse.CategoryResponse;
import co.istad.elearningcodejourney.mapping.categorymapping.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getAllCategory(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return categoryRepository.findAllByIsDeleteFalse(pageRequest)
                .map(categoryMapper::toResponse);
    }

    @Override
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findByIdAndIsDeleteFalse(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id %d not found".formatted(id)
                ));
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        if (categoryRepository.existsByName(request.name())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category name '%s' already exists".formatted(request.name())
            );
        }
        Category category = categoryMapper.toEntity(request);
        category = categoryRepository.save(category);
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse updateCategoryById(Integer id, UpdateCategoryRequest request) {
        Category exitCategory = categoryRepository.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Category with id %d not found".formatted(id)
        ));

        if (request.name()!=null){
            exitCategory.setName(request.name());
        }
        if (request.icon()!=null){
            exitCategory.setIcon(request.icon());
        }

        Category updateProduct = categoryRepository.save(exitCategory);
        return categoryMapper.toResponse(updateProduct);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id %d not found".formatted(id)
                ));
        category.setIsDelete(true);
        categoryRepository.save(category);
    }
}
