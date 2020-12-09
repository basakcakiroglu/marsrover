package processor;

import enviroment.Rover;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputProcessorTest {

    @Test
    public void testGeneratedRovers() {
        InputStream in = new ByteArrayInputStream("5 5\n1 2 N\nLMLMLMLMM".getBytes());
        Scanner scanner = new Scanner(in);

        InputProcessor processor = InputProcessor.getInstance();
        List<Rover> rovers = processor.generateRovers(scanner);
        assertEquals(1, rovers.size());
        Rover rover = rovers.iterator().next();
        assertEquals("1 2 N", rover.getPosition());
        rover.executeMovements();
        assertEquals("1 3 N", rover.getPosition());

    }

}