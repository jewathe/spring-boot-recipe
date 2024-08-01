package com.kiwi.spring_boot_recipe.dao;

import com.kiwi.spring_boot_recipe.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;



public interface ReviewRepository extends JpaRepository<Review,Long> {

 Page<Review> findByRecipeId(@RequestParam("recipe_id") Long recipeId, Pageable pageable);
}
