package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

// сделать через spy
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;


    @Test
    public void testEatMeat() throws Exception {
        Feline notMockFeline = new Feline();
        List<String> whatFelineEat = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Felines should eat: \"Животные\", \"Птицы\", \"Рыба\"", notMockFeline.eatMeat(), whatFelineEat);
    }

    @Test
    public void testGetFamily() {
        Feline notMockFeline = new Feline();
        assertEquals("Animal family should be: 'Кошачьи'", "Кошачьи", notMockFeline.getFamily());
    }


    @Test
    public void testGetKittens() {
        assertEquals( "Count of kittens should be 1", 1, feline.getKittens());
    }


    @Test
    public void testGetKittensWithParams() {
       assertEquals("Count of kittens should be equals to parameter ", 15, feline.getKittens(15));
    }
}
