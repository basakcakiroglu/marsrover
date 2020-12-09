package enviroment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {


    @Test
    public void testDirectionRotateLeft(){
        assertEquals(Direction.NORTH, Direction.EAST.rotateLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.rotateLeft());
        assertEquals(Direction.WEST, Direction.NORTH.rotateLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.rotateLeft());
    }

    @Test
    public void testDirectionRotateRight(){
        assertEquals(Direction.SOUTH, Direction.EAST.rotateRight());
        assertEquals(Direction.NORTH, Direction.WEST.rotateRight());
        assertEquals(Direction.EAST, Direction.NORTH.rotateRight());
        assertEquals(Direction.WEST, Direction.SOUTH.rotateRight());
    }

    @Test
    public void testDirectionsMap(){
        assertEquals(Direction.SOUTH, Direction.get("S"));
        assertEquals(Direction.NORTH, Direction.get("N"));
        assertEquals(Direction.WEST, Direction.get("W"));
        assertEquals(Direction.EAST, Direction.get("E"));
    }

}