package gr.aueb.cf.ch8;

import java.util.Scanner;

/**
 * Exercises from the Exceptions notes.
 *
 * @author Michalis Koutrakis
 */
public class ExceptionsApp {

    public static void main(String[] args) {
        int choice = -1;

        printMenu();
        while (true) {
            try {
                System.out.println("Please pick an option:");
                choice = getChoice();

                if (choice == 5) {
                    System.out.println("Bye!");
                    break;
                }

                printChoice(choice);
            } catch (IllegalArgumentException e) {
                System.out.println("Please insert a valid choice");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Taxi Driver");
        System.out.println("2. Pulp Fiction");
        System.out.println("3. Psycho");
        System.out.println("4. Paris Texas");
        System.out.println("5. Exit");
    }

    /**
     * Returns an integer taken by the user.
     * @return  the integer read, otherwise -1.
     */
    public static int getChoice() {
        int num = -1;
        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()) {
            num = in.nextInt();
        } else {
            // Consume the line with invalid input
            in.nextLine();
        }
        return num;
    }

    /**
     * Prints the choice that corresponds to the choice given
     * @param choice
     *          The choice whose text we want to print.
     * @throws IllegalArgumentException
     *          Throws if the choice given is out of range.
     */
    public static void printChoice(int choice) throws IllegalArgumentException {
        switch (choice) {
            case 1:
                System.out.println("Taxi Driver 1976");
                break;
            case 2:
                System.out.println("Pulp Fiction 1994");
                break;
            case 3:
                System.out.println("Psycho 1960");
                break;
            case 4:
                System.out.println("Paris Texas 1984");
                break;
            default:
                throw new IllegalArgumentException("Invalid choice given.");
        }
    }
}
