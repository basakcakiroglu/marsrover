package enviroment;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PositionTest {


    private Plateau plateau;

    @BeforeEach
    public void initialisePlateau(){
        plateau = mock(Plateau.class);
        when(plateau.getX()).thenReturn(5);
        when(plateau.getY()).thenReturn(5);
    }


    @Test
    public void testMoveNorthWhenPositionInBoundary() {
        Position position = new Position(3, 3, Direction.NORTH);
        position.moveForward(plateau);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }

    @Test
    public void testMoveWestWhenPositionInBoundary() {
        Position position = new Position(3, 3, Direction.WEST);
        position.moveForward(plateau);
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }


    @Test
    public void testMoveSouthWhenPositionOutBoundary() {
        Position position = new Position(0, 3, Direction.WEST);
        String message = null;
        try {
            position.moveForward(plateau);
        } catch (IllegalArgumentException exception) {
            message = exception.getMessage();
        }finally {
            assertEquals("Move is not valid!", message);
        }
    }

    @Test
    public void testCurrentPosition() {
        Position mockPosition = new Position(0, 3, Direction.WEST);
        assertEquals("0 3 W", mockPosition.toString());
    }

}