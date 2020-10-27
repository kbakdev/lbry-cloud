package lbrys.data;

import org.springframework.data.repository.CrudRepository;

import lbrys.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {

}
