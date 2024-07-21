package gr.aueb.cf.fiveProjects.theater.exceptions;

public class InvalidSeatException extends Exception {
    final static long serialVersionUID = 1L;

    public InvalidSeatException() {
        super("This seat is invalid.");
    }

    public InvalidSeatException(String seat) {
        super("Seat '" + seat + "' is invalid");
    }
}
