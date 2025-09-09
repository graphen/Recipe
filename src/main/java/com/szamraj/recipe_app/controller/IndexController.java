package com.szamraj.recipe_app.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.szamraj.recipe_app.command.RecipeCommand;
import com.szamraj.recipe_app.service.RecipeService;

@Controller
public class IndexController {
    
    private final RecipeService recipeService;
    
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    
    @GetMapping({"/list", "/", ""})
    public String listRecipes(Model model) {
        Set<RecipeCommand> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes/list";
    }
}
