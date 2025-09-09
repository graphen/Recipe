package com.szamraj.spring_guru_9_spring_webapp3.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szamraj.spring_guru_9_spring_webapp3.command.IngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.converter.IngredientCommandToIngredient;
import com.szamraj.spring_guru_9_spring_webapp3.converter.IngredientToIngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Ingredient;
import com.szamraj.spring_guru_9_spring_webapp3.repository.IngredientRepository;
import com.szamraj.spring_guru_9_spring_webapp3.repository.RecipeIngredientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
	
	private final IngredientRepository ingredientRepository;
	private final RecipeIngredientRepository recipeIngredientRepository;
	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	private final IngredientCommandToIngredient ingredientCommandToIngredient;
	
	public IngredientServiceImpl(IngredientRepository ingredientRepository,
			RecipeIngredientRepository recipeIngredientRepository,
			IngredientToIngredientCommand ingredientToIngredientCommand,
			IngredientCommandToIngredient ingredientCommandToIngredient) {
		super();
		this.ingredientRepository = ingredientRepository;
		this.recipeIngredientRepository = recipeIngredientRepository;
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<IngredientCommand> getAllIngredients() {
		log.info("Getting all ingredients");
		Iterable<Ingredient> ingredients = ingredientRepository.findAll();
		Set<IngredientCommand> ingredientCommands = StreamSupport
				.stream(ingredients.spliterator(), false)
				.map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
				.collect(Collectors.toSet());
		return ingredientCommands;
	}
	
	@Override
	@Transactional(readOnly = true)
	public IngredientCommand findIngredientById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Ingredient ID cannot be null");
        }
		log.info("Finding ingredient with id: {}", id);
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        
        if (ingredientOptional.isEmpty()) {
            throw new RuntimeException("Ingredient with ID " + id + " not found");
        }
        return ingredientToIngredientCommand.convert(ingredientOptional.get());
	}

	@Override
	public IngredientCommand saveIngredient(IngredientCommand ingredientCommand) {
        if (ingredientCommand == null) {
            throw new IllegalArgumentException("Ingredient command cannot be null");
        }
        
        if (ingredientCommand.getDescription() == null || ingredientCommand.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Ingredient description cannot be empty");
        }
        log.info("Saving ingredient...");
		Ingredient newIngredient = ingredientCommandToIngredient.convert(ingredientCommand);
		Ingredient savedIngredient = ingredientRepository.save(newIngredient);
		
		log.info("Saved ingredient with id: {}", savedIngredient.getId());
		IngredientCommand savedIngredientCommand = ingredientToIngredientCommand.convert(savedIngredient);
		
		return savedIngredientCommand;
	}
	
	@Override
	public void deleteIngredientById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Ingredient ID cannot be null");
        }
        
		log.info("Deleting ingredient with id: {}", id);
        if (!ingredientRepository.existsById(id)) {
            throw new RuntimeException("Ingredient with ID " + id + " not found");
        }
        if (isIngredientUsedInRecipes(id)) {
            long recipeCount = getRecipeCountForIngredient(id);
            throw new IllegalStateException(
                String.format("Cannot delete ingredient. It is currently used in %d recipe(s).", recipeCount)
            );
        }
		ingredientRepository.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean isIngredientUsedInRecipes(Long id) {
		return recipeIngredientRepository.existsByIngredientId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public long getRecipeCountForIngredient(Long id) {
		return recipeIngredientRepository.countByIngredientId(id);
	}
}
