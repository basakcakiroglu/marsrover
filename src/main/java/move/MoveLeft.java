package move;


import enviroment.Rover;

public class MoveLeft implements IMove {
    @Override
    public void move(Rover rover) {
        rover.left();
    }
}
