package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Lion should eat: 'Животные, Птицы, Рыба'", food, lion.getFood());
    }

    @Test
    public void testLionException() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        try {
            lion.getFood();
        } catch (Exception e) {
            assertEquals("Ожидаемая ошибка: 'Неизвестный вид животного, используйте значение Травоядное или Хищник'", "Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void lionException () throws Exception{
        Lion lion = new Lion("Самей", new Feline());
        assertThrows(Exception.class, () -> lion.doesHaveMane());
    }

}