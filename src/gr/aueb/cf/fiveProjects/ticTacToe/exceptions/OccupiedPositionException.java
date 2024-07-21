package gr.aueb.cf.fiveProjects.ticTacToe.exceptions;

public class OccupiedPositionException extends Exception {
    final static long serialVersionUID = 1L;

    public OccupiedPositionException() {
        super("Thw position is occupied.");
    }

    public OccupiedPositionException(String position) {
        super("Position '" + position + "' is occupied.");
    }
}
