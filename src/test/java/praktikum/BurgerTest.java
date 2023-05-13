package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BurgerTest {
    private Burger burger;
    private Ingredient ingredient;
    @Before
    public void setup() {
        burger = new Burger();
        Bun bun = new Bun("black bun", 100);
        burger.setBuns(bun);
        for (int i = 0; i < 6; i++) {
            ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100 + i);
            burger.ingredients.add(ingredient);
        }
    }
    @After
    public void clearData() {
        burger.ingredients.clear();
    }
    @Test
    public void checkAddIngredientInListIngredient() {
        burger.ingredients.clear();
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }
    @Test
    public void checkRemoveIngredientInListIngredient() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void checkMoveIngredientInListIngredient() {
        float priceExp = burger.ingredients.get(3).price;
        String nameExp = burger.ingredients.get(3).name;
        burger.moveIngredient(3, 2);
        Assert.assertEquals(priceExp, burger.ingredients.get(2).price, 0);
        Assert.assertEquals(nameExp, burger.ingredients.get(2).name);
    }
    @Test
    public void checkGetPriceBurgerReturnCorrectValue() {
        float price = 100 * 2 + (100 + 101 + 102 + 103 + 104 + 105);
        Assert.assertEquals(price, burger.getPrice(), 0);
    }
    @Test
    public void checkGetReceiptReturnCorrectFormat() {
        String expected = String.format("(==== black bun ====)%n" +
                "= sauce hot sauce =%n" +
                "= sauce hot sauce =%n" +
                "= sauce hot sauce =%n" +
                "= sauce hot sauce =%n" +
                "= sauce hot sauce =%n" +
                "= sauce hot sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 815,000000%n");
        String actual = burger.getReceipt();
        Assert.assertEquals(expected, actual);
    }
}
