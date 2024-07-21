package gr.aueb.cf.fiveProjects.ticTacToe.exceptions;

public class InvalidPositionException extends Exception {
    final static long serialVersionUID = 1L;

    public InvalidPositionException() {
        super("The position is not valid.");
    }

    public InvalidPositionException(String position) {
        super("Position '" + position + "' is not valid.");
    }
}
