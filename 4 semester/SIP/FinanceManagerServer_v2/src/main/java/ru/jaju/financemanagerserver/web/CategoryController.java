package ru.jaju.financemanagerserver.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.jaju.financemanagerserver.data.category.Category;
import ru.jaju.financemanagerserver.data.repository.CategoryRepository;
import ru.jaju.financemanagerserver.exception.CategoryNotFoundExcpetion;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/category",produces = "application/json")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public void addCategory(@RequestBody Category category, @AuthenticationPrincipal String userId) {
        category.getCategoryId().setUserId(Integer.parseInt(userId));
        categoryRepository.save(category);
    }

    @PostMapping("/list")
    public void addCategories(@RequestBody List<Category> categories, @AuthenticationPrincipal String userId) {
        categories.forEach(category -> category.getCategoryId().setUserId(Integer.parseInt(userId)));
        categoryRepository.saveAll(categories);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") String categoryId, @AuthenticationPrincipal String userId) {
        return categoryRepository.findCategoryByCategoryIdCatIdAndCategoryIdUserId(
                categoryId,
                Integer.parseInt(userId)
        ).orElseThrow(CategoryNotFoundExcpetion::new);
    }

    @GetMapping("/list")
    public List<Category> getCategories(@AuthenticationPrincipal String userId) {
        return categoryRepository.findCategoriesByCategoryIdUserId(Integer.parseInt(userId));
    }

    @DeleteMapping("/{id}")
    public void DeleteCategory(@PathVariable("id") String categoryId, @AuthenticationPrincipal String userId) {
        categoryRepository.deleteCategoryByCategoryIdCatIdAndCategoryIdUserId(categoryId, Integer.parseInt(userId));
    }

    @DeleteMapping("/list")
    public void DeleteCategories(HttpServletRequest request, @AuthenticationPrincipal String userId) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        List<String> ids = new LinkedList<>();
        jsonObject.getAsJsonArray("categories_id").forEach(jsonElement ->
                ids.add(jsonElement.getAsString()));
        categoryRepository.deleteCategoryByCategoryIdCatIdInAndCategoryIdUserId(ids, Integer.parseInt(userId));
    }

  /*  @PutMapping("/{catId}")
    public void ChangeCategory(@PathVariable("catId") int catId, HttpServletRequest request) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null) {
            throw new WrongJsonException();
        }
        Category categoryDb = categoryRepository.findById(catId).orElseThrow(CategoryNotFoundExcpetion::new);
        if (jsonObject.has("type")) {
            categoryDb.setType(jsonObject.get("type").getAsByte());
        }
        if (jsonObject.has("name") && Strings.isNotBlank(jsonObject.get("name").getAsString())) {
            categoryDb.setName(jsonObject.get("name").getAsString());
        }
        if (jsonObject.has("color")) {
            categoryDb.setColor(jsonObject.get("color").getAsInt());
        }
        if (jsonObject.has("icon")) {
            categoryDb.setColor(jsonObject.get("icon").getAsInt());
        }
        categoryRepository.save(categoryDb);
    }*/


    /*@PutMapping("/list")
    public void ChangeCategories(HttpServletRequest request) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null) {
            throw new WrongJsonException();
        }
        if (jsonObject.has("ids") && jsonObject.has("categories")) {
            List<Integer> ids = new LinkedList<>();
            JsonArray jsonObjects = jsonObject.getAsJsonArray("categories");
            jsonObject.getAsJsonArray("ids").forEach(jsonElement -> ids.add(jsonElement.getAsInt()));
            List<Category> categoriesDb = categoryRepository.findCategoriesByIdIn(ids);
            IntStream.range(0, categoriesDb.size()).forEach(id -> {
                Category category = categoriesDb.get(id);
                JsonObject categoryJson = jsonObjects.get(id).getAsJsonObject();
                if (categoryJson.has("type")) {
                    category.setType(categoryJson.get("type").getAsByte());
                }
                if (categoryJson.has("name") && Strings.isNotBlank(categoryJson.get("name").getAsString())) {
                    category.setName(categoryJson.get("name").getAsString());
                }
                if (categoryJson.has("color")) {
                    category.setColor(categoryJson.get("color").getAsInt());
                }
                if (categoryJson.has("icon")) {
                    category.setColor(categoryJson.get("icon").getAsInt());
                }
            });
            categoryRepository.saveAll(categoriesDb);
        } else {
            throw new WrongJsonException();
        }
    }*/
}
