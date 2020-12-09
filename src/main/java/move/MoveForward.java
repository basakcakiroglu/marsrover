package move;


import enviroment.Rover;

public class MoveForward implements IMove {


    @Override
    public void move(Rover rover) {
        rover.moveForward();
    }
}
