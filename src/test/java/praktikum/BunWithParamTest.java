package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class BunWithParamTest {
    private Bun bun;
    private  final String name;
    private final float price;
    public BunWithParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getBunParameters() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }
    @Before
    public void setup() {
        bun = new Bun(name,price);
    }
    @Test
    public void checkGetNameBunReturnValueName() {
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void checkGetPriceBunReturnValuePrice() {
        Assert.assertEquals(price,bun.getPrice(), 0);
    }

}
