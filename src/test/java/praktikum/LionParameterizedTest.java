package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean hasMane;


    public LionParameterizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] choosenLionSexIs() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void isLionHaveMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(lion.doesHaveMane(), hasMane);
    }

    @Test
    public void lionException () throws Exception{
        Lion lion = new Lion("Самей");
        assertThrows(Exception.class, () -> lion.doesHaveMane());
    }
}