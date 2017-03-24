import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class TestDictionary {
    private Dictionary dictionary = new Dictionary();
    private int result;

    @Test
    public void testStringDictionary() {
        dictionary.store("test");
        dictionary.store("Test");
        dictionary.store("TEST");
        dictionary.store("test1");

        result = dictionary.getOccurrence("test");
        assertTrue(result == 1);

        result = dictionary.getOccurrence("Test");
        assertTrue(result == 2);

        result = dictionary.getOccurrence("TEST");
        assertTrue(result == 3);

        result = dictionary.getOccurrence("test1");
        assertTrue(result == 1);
    }

    @Test
    public void testEmptyDictionary() {
        dictionary.store("");
        result = dictionary.getOccurrence("");
        assertTrue(result == 1);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Param cannot be null");

        dictionary.store(null);
    }
}
