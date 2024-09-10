package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CatTest {
    Cat cat = new Cat(new Feline());
    @Test
    public void testGetSound() {
       assertEquals("Мяу", cat.getSound());
    }

}
