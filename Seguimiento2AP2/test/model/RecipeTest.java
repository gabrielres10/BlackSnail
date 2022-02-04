package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecipeTest {
	
	private Recipe recipe;
	
	void setupStage1(){ //metodo de prueba 1
		recipe = new Recipe("Recipe Name");
	}
	
	void setupStage2() {
		recipe = new Recipe("Recipe Name");
		
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}

	@Test
	void stage1Test() {
		//Ejecutar metodo de prueba
		setupStage1();
		//verificar que la lista esté vacía
		assertEquals(recipe.getIngredients().size(), 0);
	}
	
	@Test
	void stage2Test() {
		//Ejecutar metodo de prueba
		setupStage2();
		//verificar que se agregaron 3 objetos enla lista de ingredientes del recipiente
		assertEquals(recipe.getIngredients().get(0).getName(), "Cebolla");
		assertEquals(recipe.getIngredients().get(0).getName(), "Ajo");
		//assertEquals(recipe.getIngredients().get(0).equals(new Ingredient("Cebolla", 315)), true);
		assertEquals(recipe.getIngredients().get(0).getName(), "Arroz");
		assertEquals(recipe.getIngredients().get(0).getWeight(), 315);
		assertEquals(recipe.getIngredients().get(0).getWeight(), 58);
	
	}
	
	

}
