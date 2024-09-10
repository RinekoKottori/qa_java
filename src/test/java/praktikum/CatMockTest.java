package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CatMockTest {
    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(food);
        assertEquals("Cats should eat: \"Животные\", \"Птицы\", \"Рыба\"", food, cat.getFood());
    }

    @Test
    public void testCatExeption() throws Exception {
        Cat cat = new Cat(feline);
        when(cat.getFood()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        try {
            cat.getFood();
        } catch (Exception e) {
            assertEquals("Ожидаемая ошибка: 'Неизвестный вид животного, используйте значение Травоядное или Хищник'", "Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}
