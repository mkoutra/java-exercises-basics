package gr.aueb.cf.fiveProjects.theater;

import gr.aueb.cf.fiveProjects.theater.exceptions.AlreadyBookedException;
import gr.aueb.cf.fiveProjects.theater.exceptions.EmptySeatException;
import gr.aueb.cf.fiveProjects.theater.exceptions.InvalidOptionException;
import gr.aueb.cf.fiveProjects.theater.exceptions.InvalidSeatException;

import java.util.Scanner;

/**
 * Theater seat booking and reservation cancelling.
 *
 * @author Michalis Koutrakis
 */
public class TheaterSeats {
    final static Scanner in = new Scanner(System.in);
    final static int ROWS = 30;
    final static int COLUMNS = 12;
    final static boolean[][] seats = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        int option = -1;
        String seat = "";
        int[] coordinates = new int[2];
        while (true) {
            printMenu();
            try {
                option = getOption();
                switch (option) {
                    case 1:
                        seat = getSeat();
                        book(seat.charAt(0), Integer.parseInt(seat.substring(1)));
                        System.out.println("Successful Booking!");
                        break;
                    case 2:
                        seat = getSeat();
                        cancel(seat.charAt(0), Integer.parseInt(seat.substring(1)));
                        System.out.println("Successful Cancellation!");
                        break;
                    case 3:
                        printTheater();
                        break;
                    case 4:
                        System.out.println("Goodbye");
                        return;
                    default: break;
                }
            } catch (InvalidSeatException | AlreadyBookedException
                     | EmptySeatException | InvalidOptionException e) {
                System.err.println(e.getMessage());
                System.out.println("Please try again");
            }
        }
    }

    public static int[] mapSeatToCoordinates(char column, int row) {
        int[] coordinates = new int[2];
        coordinates[0] = (int) (row - 1);     // row
        coordinates[1] = (int) (column - 'A');  // column
        return coordinates;
    }

    public static void printMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Print seats");
        System.out.println("4. Exit");
        System.out.print("Please insert your option: ");
    }

    public static int getOption() throws InvalidOptionException {
        String option = getInputFromUser();
        if (!option.matches("[1-4]")) {
            throw new InvalidOptionException();
        }
        return Integer.parseInt(option);
    }

    public static String getInputFromUser() {
        return in.nextLine().trim();
    }

    public static String getSeat() throws InvalidSeatException {
        System.out.println("Theater rows: 1-30");
        System.out.println("Theater columns: A-L");
        System.out.print("Please insert your seat (e.g. C2): ");
        String seat = getInputFromUser();
        if (!seat.matches("^[A-L]([1-9]|[1-2][0-9]|30)$")) {
            throw new InvalidSeatException(seat);
        }
        return seat;
    }

    public static void printTheater() {
        System.out.println("  A, B, C, D, E, F, G, H, I, J, K, L");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < COLUMNS; j++) {
                if (seats[i][j]) System.out.print("X");
                else System.out.print("-");

                if (j < COLUMNS - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void book(char column, int row) throws AlreadyBookedException {
        int[] coordinates = mapSeatToCoordinates(column, row);
        if (seats[coordinates[0]][coordinates[1]]) {
            throw new AlreadyBookedException();
        }
        seats[coordinates[0]][coordinates[1]] = true;
    }

    public static void cancel(char column, int row) throws EmptySeatException {
        int[] coordinates = mapSeatToCoordinates(column, row);
        if (!seats[coordinates[0]][coordinates[1]]) {
            throw new EmptySeatException();
        }
        seats[coordinates[0]][coordinates[1]] = false;
    }
}
