package gr.aueb.cf.fiveProjects.ticTacToe;

public class TicTacToeTable {
    final String[][] table = {{"", "", ""},
                              {"", "", ""},
                              {"", "", ""}};

    private String[] symbols = {"X", "O"};
    private String winningSymbol = "";

    public TicTacToeTable() {
    }

    public TicTacToeTable(String[] symbols) {
        this.symbols = symbols;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public String getWinningSymbol() {
        return winningSymbol;
    }

    /**
     * Inserts a symbol in the coordinates given.
     */
    public void insert(String symbol, int[] coordinates) {
        table[coordinates[0]][coordinates[1]] = symbol;
    }

    public boolean isPositionEmpty(int[] coordinates) {
        return table[coordinates[0]][coordinates[1]].isEmpty();
    }

    public void printTable() {
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
     * Checks if there is a final result in the Tic-Tac-Toe game.
     *
     * @return true if there is a winner or the game is a tie, otherwise false.
     */
    public boolean checkFinalResult() {
        boolean finalResultExists = false;

        for (String s : symbols) {
            if (checkDiagonal(s) || checkVerticalWin(s) || checkHorizontalWin(s)) {
                winningSymbol = s;
                finalResultExists = true;
                break;
            }
        }

        if (checkTie()) {
            winningSymbol = "TIE";
            finalResultExists = true;
        }

        return finalResultExists;
    }

    private boolean checkTie() {
        for (String[] row : table) {
            for (String s : row) {
                if (s.isEmpty()) return false;
            }
        }
        return true;
    }

    private boolean checkVerticalWin(final String s) {
        boolean winnerExists = false;
        for (int col = 0; col < table.length; col++) {
            if (checkSingleCol(col, s)) {
                winnerExists = true;
                break;
            }
        }
        return winnerExists;
    }

    private boolean checkSingleCol(final int col, final String s) {
        for (int row = 0; row < table.length; row++) {
            if (!table[row][col].equals(s)) return false;
        }
        return true;
    }

    private boolean checkHorizontalWin(final String s) {
        boolean winnerExists = false;
        for (int row = 0; row < table.length; row++) {
            if (checkSingleRow(row, s)) {
                winnerExists = true;
                break;
            }
        }
        return winnerExists;
    }

    private boolean checkSingleRow(final int row, final String s) {
        for (int col = 0; col < table.length; col++) {
            if (!table[row][col].equals(s)) return false;
        }
        return true;
    }

    private boolean checkDiagonal(final String s) {
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
