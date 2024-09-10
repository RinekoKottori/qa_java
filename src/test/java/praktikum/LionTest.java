package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void testGetKittens() {
        Lion lion = new Lion(feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals("Lion should eat: 'Животные, Птицы, Рыба'", food, lion.getFood());
    }

    @Test
    public void testLionExeption() throws Exception {
        Lion lion = new Lion(feline);
        when(lion.getFood()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        try {
            lion.getFood();
        } catch (Exception e) {
            assertEquals("Ожидаемая ошибка: 'Неизвестный вид животного, используйте значение Травоядное или Хищник'", "Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

}