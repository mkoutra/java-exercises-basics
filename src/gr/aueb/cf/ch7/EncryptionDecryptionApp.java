package gr.aueb.cf.ch7;

/**
 * A simple application demonstrating basic
 * encryption and decryption using ASCII-based
 * character shifting.
 *
 * @author Michalis Koutrakis
 */
public class EncryptionDecryptionApp {
    final static int ASCII_RANGE = 128;

    public static void main(String[] args) {
        String s = "kalimera";
        int step = 1;

        System.out.println("Initial string = " + s);

        String encrypted = encrypt(s, step);
        System.out.println("Encrypted = " + encrypted);

        String decrypted = decrypt(encrypted, step);
        System.out.println("Decrypted = " + decrypted);
    }

    /**
     * Encrypts a given string by shifting each character's
     * ASCII value by a specified number of steps.
     * If the shift goes beyond the ASCII range,
     * it wraps around using modulo arithmetic.
     *
     * @param initialString the original string to be encrypted
     * @param step          the number of ASCII positions
     *                      to shift each character
     * @return              a new encrypted string with characters
     *                      shifted by the specified step
     */
    public static String encrypt(String initialString, int step) {
        char[] initialStringArray = initialString.toCharArray();
        for(int i = 0; i < initialStringArray.length; i++) {
            initialStringArray[i] = (char) ((initialStringArray[i] + step) % ASCII_RANGE);
        }
        return String.valueOf(initialStringArray);
    }

    /**
     * Decrypts a given string by shifting each character's ASCII
     * value by a specified number of steps in the opposite direction.
     * This uses the same shift logic as the encryption method,
     * but with a negative step to reverse the effect.
     *
     * @param s     the encrypted string to be decrypted
     * @param step  the number of ASCII positions to shift each
     *              character in the opposite direction
     * @return      the original string after reversing
     *              the shift by the specified step
     */
    public static String decrypt(String s, int step) {
        return encrypt(s, -step);
    }
}
