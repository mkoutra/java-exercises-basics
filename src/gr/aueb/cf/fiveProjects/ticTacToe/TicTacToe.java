package gr.aueb.cf.fiveProjects.ticTacToe;

import gr.aueb.cf.fiveProjects.ticTacToe.exceptions.InvalidPositionException;
import gr.aueb.cf.fiveProjects.ticTacToe.exceptions.OccupiedPositionException;

import java.util.Map;
import java.util.Scanner;

/**
 * Two player implementation of Tic-Tac-Toe.
 *
 * @author Michalis Koutrakis
 */
public class TicTacToe {
    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        playTicTacToe();
    }

    /**
     * Play the game.
     */
    public static void playTicTacToe() {
        int currentPlayer = (int) Math.floor(Math.random() * 2);
        final TicTacToeTable table = new TicTacToeTable(new String[] {"X", "O"});
        String position;

        printInstructions(table.getSymbols());
        table.printTable();

        while (!table.checkFinalResult()) {
            System.out.println("Player " + (currentPlayer + 1) +
                    " (" + table.getSymbols()[currentPlayer] + "), it's your turn!");
            System.out.print("Enter your move: ");

            try {
                position = getPosition();
                if (position.matches("^[qQ]$")) {
                    System.out.println("Goodbye!");
                    break;
                }
                insertToTable(table, table.getSymbols()[currentPlayer], position);
                table.printTable();
                currentPlayer = getNextPlayer(currentPlayer);
            } catch (InvalidPositionException | OccupiedPositionException e) {
                System.err.println(e.getMessage());
                System.out.println("Please insert valid input.");
            }
        }
        handleFinalResult(table);
    }

    /**
     * Show the appropriate message depending on the result.
     *
     * @param table Tic-tac-toe table
     */
    public static void handleFinalResult(TicTacToeTable table) {
        String winningSymbol = table.getWinningSymbol();
        int winner = -1;

        if (winningSymbol.equals("TIE")) {
            System.out.println("We have a tie!");
        } else {
            winner = getPlayerFromSymbol(winningSymbol, table.getSymbols());
            System.out.println("Player " + (winner + 1) + " wins!");
        }
    }

    /**
     * Map symbol to player index.
     *
     * @param symbol    The symbol to map.
     * @param symbols   All the available symbols.
     * @return          The index of the player holding the symbol
     */
    public static int getPlayerFromSymbol(String symbol, String[] symbols) {
        int player = -1;

        for (int i = 0; i < symbols.length; ++i) {
            if (symbols[i].equals(symbol)) {
                player = i;
                break;
            }
        }

        return player;
    }

    /**
     * Returns the player that plays next.
     *
     * @param currentPlayer The index of the current player.
     * @return      The index of the next player (0 or 1)
     */
    public static int getNextPlayer(int currentPlayer) {
        return currentPlayer == 0 ? 1 : 0;
    }

    /**
     * Insert to table as long as the position is not occupied.
     *
     * @param table     Tic-tac-toe table.
     * @param symbol    The symbol to insert
     * @param position  The position as given by the user.
     * @throws OccupiedPositionException If the position is occupied.
     */
    public static void insertToTable(TicTacToeTable table, String symbol, String position)
            throws OccupiedPositionException{
        int[] coordinates = mapCoordinates(position);

        if (!table.isPositionEmpty(coordinates)) {
            throw new OccupiedPositionException(position);
        }

        table.insert(symbol, coordinates);
    }

    /**
     * Transforms a position given by the user
     * to array coordinates (e.g. c2 --> {2, 1}).
     *
     * @param position  The position, as given by the user
     * @return  An array with two integers representing the array coordinates.
     */
    public static int[] mapCoordinates(String position) {
        Map<Character, Integer> map = Map.of(
                'a', 0,
                'A', 0,
                'b', 1,
                'B', 1,
                'c', 2,
                'C', 2,
                '1', 0,
                '2', 1,
                '3', 2
        );
        int[] coordinates = new int[2];
        for (int i = 0; i < 2; i++) {
            coordinates[i] = (int) map.get(position.charAt(i));
        }

        return coordinates;
    }

    public static void printInstructions(String[] symbols) {
        System.out.println("TIC-TAC-TOE");
        System.out.println();
        System.out.println("Player 1: " + symbols[0]);
        System.out.println("Player 2: " + symbols[1]);
        System.out.println();
        System.out.println("Each player takes turns to place their mark (X or O) on the grid.");
        System.out.println("Enter the coordinates of your move as a letter (a, b, c) for the row");
        System.out.println("and a number (1, 2, 3) for the column.");
        System.out.println("For example: a3, c1, b2, etc.");
        System.out.println();
        System.out.println("Insert [q] or [Q] to exit.");
    }

    /**
     * Reads input from user and trims it.
     * @return users input
     */
    public static String getPositionFromUser() {
        return in.nextLine().trim();
    }

    /**
     * Reads the position from user and checks if it is valid.
     *
     * @return
     *      the position given by the user
     * @throws InvalidPositionException
     *      If the position does not correspond to any table positions.
     */
    public static String getPosition() throws InvalidPositionException {
        String position = getPositionFromUser();
        if (!isValidPosition(position)) {
            throw new InvalidPositionException(position);
        }
        return position;
    }

    public static boolean isValidPosition(String s) {
        return s.matches("^[qQ]|[a-cA-C][1-3]$");
    }
}