package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class DatabaseTest {
    private Database database;
    List<Bun> buns;
    List<Ingredient> ingredients;
    @Before
    public void setup() {
        database = new Database();
    }
    @Test
    public void checkAvailableBuns() {
        buns = new ArrayList<>();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));
        Assert.assertEquals(3,buns.size());
        Assert.assertFalse(database.availableBuns().isEmpty());
    }
    @Test
    public void checkAvailableIngredients() {
        ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
        Assert.assertEquals(6,ingredients.size());
        Assert.assertFalse(database.availableIngredients().isEmpty());
    }
}
