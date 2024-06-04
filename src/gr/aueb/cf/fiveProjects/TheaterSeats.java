package gr.aueb.cf.fiveProjects;

public class TheaterSeats {
    final static int ROWS = 30;
    final static int COLUMNS = 12;
    final static boolean[][] seats = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        printTheater();
    }

    public static void printTheater() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public void book(char column, char row) {

    }

    public void cancel(char column, char row) {

    }
}
