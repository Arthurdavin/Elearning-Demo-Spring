package co.istad.elearningcodejourney.feature.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
//    Page<Category> findAllByIsDeleteFalse(Pageable pageable);
//    Optional<Category> findByIdAndIsDeleteFalse(Integer id);
}
