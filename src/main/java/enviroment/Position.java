package enviroment;

import java.util.StringJoiner;

public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveForward(Plateau plateau) throws IllegalArgumentException {
        int newX = x + this.direction.getConvertedStepX();
        int newY = y + this.direction.getConvertedStepY();
        if ((newX >= 0 && newY >= 0)
                && (newX <= plateau.getX() && newY <= plateau.getY())) {
            this.x = newX;
            this.y = newY;
        } else {
            throw new IllegalArgumentException("Move is not valid!");
        }
    }

    public void toLeft() {
        this.direction = this.direction.rotateLeft();
    }

    public void toRight() {
        this.direction = this.direction.rotateRight();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(String.valueOf(this.x))
                .add(String.valueOf(this.y))
                .add(this.direction.toString());
        return joiner.toString();
    }
}
