package com.kiwi.spring_boot_recipe.dao;

import com.kiwi.spring_boot_recipe.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
 Page<Recipe> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);
 Page<Recipe> findByCategory(@RequestParam("category") String category, Pageable pageable);
}
