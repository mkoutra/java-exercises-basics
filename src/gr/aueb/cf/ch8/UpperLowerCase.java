package gr.aueb.cf.ch8;


public class UpperLowerCase {
    public static void main(String[] args) {
        String s ="Giorgos12";
        toUpperLower(s);
    }

    /**
     * Returns the input string given but with
     * even positions with uppercase character
     * and odd positions with lowercase.
     * @param s
     */
    public static String toUpperLower(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return sb.toString();
    }
}
