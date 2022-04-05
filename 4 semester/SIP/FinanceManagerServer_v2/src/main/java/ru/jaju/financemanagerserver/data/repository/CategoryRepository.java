package ru.jaju.financemanagerserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jaju.financemanagerserver.data.category.Category;
import ru.jaju.financemanagerserver.data.category.CategoryId;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, CategoryId> {

    List<Category> findCategoriesByCategoryIdUserId(@NotNull int userId);

    Optional<Category> findCategoryByCategoryIdCatIdAndCategoryIdUserId(@NotNull String catId, @NotNull int userId);

    @Transactional
    void deleteCategoryByCategoryIdCatIdInAndCategoryIdUserId(@NotNull List<String> catIds, @NotNull int userId);

    @Transactional
    void deleteCategoryByCategoryIdCatIdAndCategoryIdUserId(@NotNull String catId,@NotNull int userId);

    //  List<Category> findCategoriesByIdIn(@NonNull List<Integer> ids);
}
