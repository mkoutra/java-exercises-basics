package gr.aueb.cf.fiveProjects.ticTacToe;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToe {
    final static Scanner in = new Scanner(System.in);
    final static String table[][] = {{"", "", ""},
                                     {"", "", ""},
                                     {"", "", ""}};


    public static void main(String[] args) {
        int activePlayer = (int) Math.floor(Math.random() * 2);
        String position;
        String[] symbols = {"X", "O"};

        printInstructions(symbols);
        printTable();

        while (true) {
            System.out.println("Player " + (activePlayer + 1) + " is your turn.");
            System.out.print("Insert table position: ");
            position = getInput();

            if (position.matches("^[qQ]$")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!validatePosition(position)) {
                System.out.println("Please insert valid input.");
                continue;
            }

            if (insertToTable(symbols[activePlayer], position) == -1) {
                System.out.println("Please insert an empty position.");
                continue;
            }
            printTable();
            if (!checkWin(symbols).isEmpty()) {
                System.out.println(checkWin(symbols));
                break;
            }
            activePlayer = ++activePlayer % 2;
        }

    }

    public static int insertToTable(String symbol, String position) {
        int[] coordinates = mapCoordinates(position);
        if (!isPositionEmpty(coordinates)) {
            return -1;
        }
        tableInsert(symbol, coordinates);
        return 0;
    }

    public static void tableInsert(String symbol, int[] coordinates) {
        table[coordinates[0]][coordinates[1]] = symbol;
    }

    public static boolean isPositionEmpty(int[] coordinates) {
        return table[coordinates[0]][coordinates[1]].isEmpty();
    }

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

    public static String getInput() {
        return in.nextLine().trim();
    }

    public static boolean validatePosition(String s) {
        return s.matches("^[a-cA-C][1-3]$");
    }

    public static void printTable() {
        char[] rowNames = {'a', 'b', 'c'};
        System.out.println("   1     2     3");

        for (int i = 0; i < table.length; i++) {
            System.out.println("      |     |     ");
            System.out.print(rowNames[i]);

            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].isEmpty())  System.out.print("     ");
                else System.out.printf("  %s  ", table[i][j]);

                if (j < 2) System.out.print("|");
            }

            if (i < 2) System.out.println("\n  ____|_____|_____");
            else System.out.println("\n      |     |     ");
        }
    }

    /**
     * Checks if there is a winner, and returns the symbol of the winner.
     * If there is no winner, it returns the empty string "".
     *
     * @param symbols
     *      The symbols for each player
     * @return
     *      The symbol string of the winner, otherwise
     *      it returns the empty string "".
     */
    public static String checkWin(final String[] symbols) {
        String winningSymbol = "";

        if (checkTie()) return "Tie!";

        for (String s : symbols) {
            if (checkDiagonal(s) || checkVerticalWin(s) || checkHorizontalWin(s)) {
                winningSymbol = s;
            }
        }

        return winningSymbol;
    }

    public static boolean checkTie() {
        for (String[] row : table) {
            for (String s : row) {
                if (s.isEmpty()) return false;
            }
        }
        return true;
    }

    private static boolean checkVerticalWin(final String s) {
        boolean winnerExists = false;
        for (int col = 0; col < table.length; col++) {
            if (checkSingleCol(col, s)) {
                winnerExists = true;
                break;
            }
        }
        return winnerExists;
    }

    private static boolean checkSingleCol(final int col, final String s) {
        for (int row = 0; row < table.length; row++) {
            if (!table[row][col].equals(s)) return false;
        }
        return true;
    }

    private static boolean checkHorizontalWin(final String s) {
        boolean winnerExists = false;
        for (int row = 0; row < table.length; row++) {
            if (checkSingleRow(row, s)) {
                winnerExists = true;
                break;
            }
        }
        return winnerExists;
    }

    private static boolean checkSingleRow(final int row, final String s) {
        for (int col = 0; col < table.length; col++) {
            if (!table[row][col].equals(s)) return false;
        }
        return true;
    }

    private static boolean checkDiagonal(final String s) {
        boolean diagonalWins = true;

        // 1st diagonal
        for (int i = 0; i < table.length; i++) {
            if (!table[i][i].equals(s)) {
                diagonalWins = false;
                break;
            }
        }

        // 2nd diagonal
        if (!diagonalWins) {
            diagonalWins = true;

            for(int i = table.length - 1; i >= 0; i--) {
                if (!table[table.length - 1 - i][i].equals(s)) {
                    diagonalWins = false;
                    break;
                }
            }
        }

        return diagonalWins;
    }
}