package sbu.cs.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private static Reader reader;

    @BeforeAll
    static void setup() {
        reader = new Reader();
    }

    @Test
    void readCommandTwitterNoException() {
        List<String> implementedCommands = Util.getImplementedCommands();
        Collections.shuffle(implementedCommands);
        reader.readTwitterCommands(implementedCommands);
    }

    @Test
    void readCommandTwitterExceptionNotImpl() {
        List<String> commands = new ArrayList<>(Util.getImplementedCommands());
        commands.addAll(Util.getNotImplementedCommands());
        Collections.shuffle(commands);
        assertThrows(ApException.class, () -> {
            reader.readTwitterCommands(commands);
        });
    }

    @Test
    void readCommandTwitterExceptionUnrecognized() {
        List<String> commands = new ArrayList<>();
        commands.add("apply");
        assertThrows(ApException.class, () -> {
            reader.readTwitterCommands(commands);
        });
    }

    @Test
    void readValidInput() {
        reader.read("ap", "3", "9", "9", "2", "1400", "Beheshti", "38", "computer science");
    }

    @Test
    void readInvalidInput() {
        assertThrows(ApException.class, () -> {
            reader.read("ap", "3", "9", "9", "2", "Beheshti", "38", "computer science", "1400");
        });
    }
}