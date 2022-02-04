package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IngredientTest {
private Ingredient tomato;
	
	void setupStage1(){ //metodo de prueba 1
		tomato = new Ingredient("Tomate", 245);
	}

	@Test
	void test() {
		//Ejecutar metodo de prueba
		setupStage1();
		//Commparar que el nombre sea
		
		assertEquals(tomato.getName(), "Tomate"); //La prueba solo sirve para el programador revisar que se están guardando los datos correctamente, nada mas, no se ejecuta en el codigo que el usuario utiliza
		assertEquals(tomato.getWeight(), 245);
		
		
		
	}

}
