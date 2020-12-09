package processor;

import enviroment.Direction;
import enviroment.Plateau;
import enviroment.Position;
import enviroment.Rover;
import move.IMove;
import move.MoveForward;
import move.MoveLeft;
import move.MoveRight;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputProcessor {

    private static InputProcessor instance;

    private InputProcessor() {
    }

    public synchronized static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    public List<Rover> generateRovers(Scanner scanner) {
        Plateau plateau = parseGrid(scanner.nextLine());
        return createRovers(plateau, scanner);
    }

    private List<Rover> createRovers(Plateau plateau, Scanner scanner) {
        List<Rover> rovers = new LinkedList<>();
        while (scanner.hasNext()) {
            Position position = generatePosition(scanner.nextLine());
            List<IMove> moveList = generateMovements(scanner.nextLine());
            rovers.add(new Rover(plateau, position, moveList));
        }
        return rovers;
    }

    private List<IMove> generateMovements(String input) {
        return input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .map(this::getMoveOf)
                .collect(Collectors.toList());
    }

    private IMove getMoveOf(String movementKey) {
        switch (movementKey) {
            case "M":
                return new MoveForward();
            case "L":
                return new MoveLeft();
            case "R":
                return new MoveRight();
            default:
                throw new IllegalArgumentException("Invalid movement" + movementKey);
        }
    }

    private Plateau parseGrid(String input) {
        String[] coordinates = input.split(" ");
        return new Plateau(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    private Position generatePosition(String input) {
        String[] position = input.split(" ");
        return new Position(Integer.parseInt(position[0]), Integer.parseInt(position[1]), Direction.get(position[2]));
    }

}
