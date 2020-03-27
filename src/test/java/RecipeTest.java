import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    @Test
    void constructorTest(){
        //Invalid blank names:
        assertThrows(IllegalArgumentException.class, ()-> new Recipe(""));
        assertThrows(IllegalArgumentException.class, ()-> new Recipe(" "));
        assertThrows(IllegalArgumentException.class, ()-> new Recipe("           "));

        //Valid names:
        Recipe r;
        r = new Recipe("valid name");
        r = new Recipe("571%25&3 and this still works");
    }

    @Test
    void getPrintableTest(){
        ArrayList<String> steps = new ArrayList<String>();
        steps.add("First add the eggs");
        Food food = new Food("Eggs", 100);
        Ingredient ingredient = new Ingredient(food, 100, "g");
        ArrayList<Ingredient> ingredients = new ArrayList();
        ingredients.add(ingredient);

        Recipe recipe = new Recipe("Raw Eggs", steps, ingredients);
        assertEquals("1:  First add the eggs\n", recipe.getPrintableSteps());
        assertEquals("Eggs\n", recipe.getPrintableIngredients());
    }


}
