package gr.aueb.cf.fiveProjects.theater.exceptions;

public class InvalidOptionException extends Exception {
    final static long serialVersionUID = 1L;

    public InvalidOptionException() {
        super("Invalid option");
    }
}
