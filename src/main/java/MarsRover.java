import processor.InputProcessor;

import java.util.Scanner;

public class MarsRover {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide instructions and then quit program:\n");
        InputProcessor processor = InputProcessor.getInstance();
        processor.generateRovers(scanner).forEach(rover -> {
            rover.executeMovements();
            System.out.println(rover.getPosition());
        });
    }
}
