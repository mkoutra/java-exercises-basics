package gr.aueb.cf.ch8;

public class ZerosBetweenOnes {

    public static void main(String[] args) {
        int num = 81;
        String s = Integer.toBinaryString(num);

        System.out.println(num + ": max zeroes = " +  maxZeroesBetweenOnes(s));
        System.out.println(num + ": max zeroes = " +  maxZeroesBetweenOnesSol(num));
    }

    public static int maxZeroesBetweenOnes(String s) {
        int firstOne = 0;
        int zeroesCounter = 0;
        int max = 0;

        // Find the position of the first one.
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                firstOne = i;
                break;
            }
        }

        for (int i = firstOne; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                zeroesCounter++;
            }

            if (s.charAt(i) == '1') {
                if (max < zeroesCounter) {
                    max = zeroesCounter;
                }
                zeroesCounter = 0;
            }
        }

        return max;
    }

    public static int maxZeroesBetweenOnesSol(int n) {
        int count = 0;
        boolean oneFlag = false;
        int max = 0;

        for (; n > 0; n >>= 1) {
            // If rightmost bit is one
            if (n % 2 != 0) {
                oneFlag = true;
                if (count > max) {
                    max = count;
                }
                count = 0;
            } else if (oneFlag) {
                count++;
            }
        }

        return max;
    }
}
