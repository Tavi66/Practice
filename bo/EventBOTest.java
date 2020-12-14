package bo;

import domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class EventBOTest {
    private EventBO bo;

    @BeforeEach
    void setupBO() {
        bo = new EventBO();
    }
    @Test
    void insert() {
        Event event = new Event(4,"Revolution","Fall of nobles");
        bo.insert(event);
        assertNotNull(bo.find(4));
    }

    @Test
    void list() {
        List<Event> expected = Arrays.asList(
                new Event(4,"Revolution","Fall of nobles")
        );
        List<Event> actual = bo.list();
        assertEquals(expected,actual);
    }

    @Test
    void find() {
        assertNotNull(bo.find(4));
    }

    static boolean assertEquals(List<Event> expected, List<Event> actual)
    {
        boolean equals = true;
        if(expected.size()!=actual.size())
        {equals=false;}
        else {
            int size = expected.size();
            for(int i = 0; i<size;i++)
            {
                Event e = expected.get(i);
                Event a = actual.get(i);
                if (!a.getName().equals(e.getName()) || !a.getDetail().equals(e.getDetail()) || !a.getId().equals(e.getId())) {
                    equals = false;
                    break;
                }
            }
        }
        return equals;
    }
}