package gr.aueb.cf.fiveProjects.theater.exceptions;

public class EmptySeatException extends Exception {
    final static long serialVersionUID = 1L;

    public EmptySeatException() {
        super("The seat is empty");
    }
}
