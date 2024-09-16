package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
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
        when(feline.getKittens()).thenReturn(1);
        assertEquals("Count of kittens should be 1", 1, feline.getKittens());
    }


    @Test
    public void testGetKittensWithParams() {
        when(feline.getKittens(15)).thenReturn(15);
        assertEquals("Count of kittens should be equals to parameter ", 15, feline.getKittens(15));
    }
}
