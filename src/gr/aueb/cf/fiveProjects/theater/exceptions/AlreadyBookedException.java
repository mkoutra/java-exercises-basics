package gr.aueb.cf.fiveProjects.theater.exceptions;

public class AlreadyBookedException extends Exception {
    final static long serialVersionUID = 1L;

    public AlreadyBookedException() {
        super("The seat has been already booked.");
    }
}
