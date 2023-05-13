package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientWithParamTest {
    private  Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientWithParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientParameters() {
        return new Object[][]{
                {IngredientType.SAUCE,"hot sauce", 100},
                {IngredientType.SAUCE,"sour cream", 200},
                {IngredientType.SAUCE,"chili sauce", 300},
                {IngredientType.FILLING,"cutlet", 100},
                {IngredientType.FILLING,"dinosaur", 200},
                {IngredientType.FILLING,"sausage", 300},
        };
    }
    @Before
    public void setup() {
        ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void checkGetPriceIngredientReturnValuePrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
    @Test
    public void checkGetNameIngredientReturnValueName() {
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void checkGetTypeIngredientReturnValueType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
