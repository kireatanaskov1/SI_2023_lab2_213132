import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    public void EveryBranch() {
        RuntimeException ex;

        // testovi za if statementot oznacen so broj 2
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("null", null, "null"), new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("null", "null", null), new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // test za password kratok pokratok od 8 karakteri
        assertFalse(SILab2.function(new User("username", "ascd", "asdfew"), new LinkedList<>()));

        // test za return false koga pasvordot sodrzi specijalen karakter
        assertFalse(SILab2.function(new User("username", "asdjkne$dq", "testemail"), new LinkedList<>()));

        // test koga programata zavrsuva vo return false na linija 27 (ne frla exception vo 2 i ne vrakja return bidejkji password ne sodrzi spec karakter
        assertFalse(SILab2.function(new User("username", "abvgdgzjzs", "test@email.com"),
                List.of(new User("username", "abvgdgzjzs", "test@email.com"),
                        new User("test", "test", "test"))));

        // test koga username e null (programata zavrsuva so return false vo 27, no od 4 vleguva vo 5 bidejkji username e null)
        assertFalse(SILab2.function(new User(null, "qwertyuio", "test@email.com"), new LinkedList<>()));
    }

    @Test
    public void MultipleCondition() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "email"), new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "password", null), new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, null), new LinkedList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
}