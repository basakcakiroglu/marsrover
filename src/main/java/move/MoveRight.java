package move;


import enviroment.Rover;

public class MoveRight implements IMove {
    @Override
    public void move(Rover rover) {
        rover.right();
    }
}
