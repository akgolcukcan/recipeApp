package com.pluralsight.recipe.controller;

import com.pluralsight.recipe.model.Recipe;
import com.pluralsight.recipe.repositories.RecipeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeRestController {

    // comment

    @Autowired
    private RecipeJpaRepository jpaRepository;


    @GetMapping("")
    public List<Recipe> listRecipes() {
        return jpaRepository.findAll();
    }


    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return jpaRepository.getById(id);
    }


    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return jpaRepository.save(recipe);
    }


    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        Recipe r = jpaRepository.getById(id);
        r.setName(recipe.getName());
        r.setDescription(recipe.getDescription());
        return jpaRepository.save(r);
    }


    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        jpaRepository.deleteById(id);
    }

}
