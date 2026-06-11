package co.istad.elearningcodejourney.feature.category;

import co.istad.elearningcodejourney.feature.category.dto.CreateCategoryRequest;
import co.istad.elearningcodejourney.feature.category.dto.request.UpdateCategoryRequest;
import co.istad.elearningcodejourney.feature.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getAllCategory(Integer page, Integer size) {
        Sort sortById = Sort.by(Sort.Direction.DESC,"id");
        PageRequest pageRequest = PageRequest.of(page,size,sortById);
        return categoryRepository
                .findAll(pageRequest)
                .map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id %d not found".formatted(id)
                ));
        return categoryMapper.categoryToCategoryResponse(category);
    }

//    @Override
//    public CategoryResponse createCategory(CreateCategoryRequest request) {
//        log.info("createCategory: {}",request);
//        if (categoryRepository.existsByName(request.name())){
//            throw new ResponseStatusException(
//                    HttpStatus.CONFLICT,
//                    "Category name '%s' already exists".formatted(request.name())
//            );
//        }
//        Category category = categoryMapper.categoryRequestToCategory(request);
//        category = categoryRepository.save(category);
//        return categoryMapper.categoryToCategoryResponse(category);
//    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest categoryRequest) {
        log.info("createCategory: {}", categoryRequest);

        if (categoryRepository.existsByName(categoryRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists!");
        }

        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);

        // Safety check: ensure if request has null, we fall back to a default false state
        if (category.getIsDeleted() == null) {
            category.setIsDeleted(false);
        }

        category = categoryRepository.save(category);

        return categoryMapper.categoryToCategoryResponse(category);
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
        return categoryMapper.categoryToCategoryResponse(updateProduct);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        log.info("deleteCategory: {}",id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id %d not found".formatted(id)
                ));
        categoryRepository.delete(category);
    }
}
