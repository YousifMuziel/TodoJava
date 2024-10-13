import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ToDoTest {

    @Test
    public void testDefaultConstructor() {
        ToDo todo = new ToDo();
        assertEquals("No Item", todo.getTitle());
        assertEquals(false, todo.getCompleted());
    }

    @Test
    public void testOverloadedConstructor() {
        ToDo todo = new ToDo("Walk Dog", false);
        assertEquals("Walk Dog", todo.getTitle());
        assertEquals(false, todo.getCompleted());
    }

    @Test
    public void testConvertTimeValidInput() {
        ToDo todo = new ToDo();
        todo.convertTime("11:00");
        assertEquals(11, todo.getHours());
        assertEquals(0, todo.getMinutes());
        assertEquals(true, todo.getCompleted());
    }

    @Test
    public void testConvertTimeInvalidInput() {
        ToDo todo = new ToDo();
        todo.convertTime("24:25");
        assertEquals(-1, todo.getHours());
        assertEquals(25, todo.getMinutes());
        assertEquals(false, todo.getCompleted());

        todo.convertTime("13:60");
        assertEquals(13, todo.getHours());
        assertEquals(-1, todo.getMinutes());
        assertEquals(false, todo.getCompleted());
    }
}
