package enviroment;

import move.MoveLeft;
import move.MoveRight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoverTest {

    private Plateau plateau;

    @BeforeEach
    public void initialisePlateau() {
        plateau = mock(Plateau.class);
        when(plateau.getX()).thenReturn(5);
        when(plateau.getY()).thenReturn(5);
    }

    @Test
    public void testRoverCantMoveOnGivenPosition() {
        Rover rover = new Rover(plateau, getMockPosition(), Collections.emptyList());
        try {
            rover.moveForward();
        } catch (IllegalArgumentException exception) {
            assertEquals("Move is not valid!", exception.getMessage());
        }
    }

    @Test
    public void testAllMovementsExecuted() {
        Rover rover = new Rover(plateau, getMockPosition(), Collections.emptyList());
        MoveLeft left = mock(MoveLeft.class);
        MoveRight right = mock(MoveRight.class);
        rover.assignedMovements.add(right);
        rover.assignedMovements.add(left);
        rover.executeMovements();
        verify(left, times(1)).move(rover);
        verify(right, times(1)).move(rover);
    }


    private Position getMockPosition() {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(0);
        when(mockPosition.getY()).thenReturn(0);
        when(mockPosition.getDirection()).thenReturn(Direction.SOUTH);
        return mockPosition;
    }

}