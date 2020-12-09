package enviroment;


import move.IMove;

import java.util.LinkedList;
import java.util.List;

public class Rover {

    private final Plateau plateau;
    private final Position position;
    protected final List<IMove> assignedMovements = new LinkedList<>();

    public Rover(Plateau plateau, Position position, List<IMove> moveList) {
        this.plateau = plateau;
        this.position = position;
        this.assignedMovements.addAll(moveList);
    }

    public void executeMovements() {
        assignedMovements.forEach(movement -> movement.move(this));
    }

    public void moveForward() {
        try {
            position.moveForward(plateau);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void left() {
        this.position.toLeft();
    }

    public void right() {
        this.position.toRight();
    }

    public String getPosition() {
        return this.position.toString();
    }
}
