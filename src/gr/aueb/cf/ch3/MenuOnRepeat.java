package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Prints a simple menu and asks
 * user to select an option.
 *
 * @author Michalis Koutrakis
 */
public class MenuOnRepeat {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option = -1;

        while (true) {
            System.out.println("1. Εισαγωγή");
            System.out.println("2. Διαγραφή");
            System.out.println("3. Ενημέρωση");
            System.out.println("4. Αναζήτηση");
            System.out.println("5. Έξοδος");

            // Read user input
            System.out.print(">> ");
            option = in.nextInt();

            if (option < 0) {
                System.out.println("Error: Option must be a positive integer.");
                System.exit(1);
            }

            if (option > 5) {
                System.out.println("Error: Option out of bounds.");
                System.exit(1);
            }

            if (option == 1) {
                System.out.println("Επιλέξατε Εισαγωγή");
            } else if (option == 2){
                System.out.println("Επιλέξατε Διαγραφή");
            } else if (option == 3){
                System.out.println("Επιλέξατε Ενημέρωση");
            } else if (option == 4){
                System.out.println("Επιλέξατε Αναζήτηση");
            } else {
                System.out.println("Έξοδος");
                break;
            }
        }
    }
}
