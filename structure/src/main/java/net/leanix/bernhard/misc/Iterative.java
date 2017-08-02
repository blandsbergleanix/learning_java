package net.leanix.bernhard.misc;

public class Iterative {

    public int sumi(int a, int b) {
        if ( b == 0 ) {
            return a;
        }
        if ( a == 0 ) {
            return b;
        }

        int result = a;

        if (b > 0) {
            for (int i = 0; i < b; i++) {
                result++;
            }
        }
        else {
            for (int i = 0; i < Math.abs(b); i++) {
                result--;
            }
        }
        return result;
    }

    public int prodi(int a, int b) {
        if ( b == 1 ) {
            return a;
        }
        if ( a == 1 ) {
            return b;
        }
        if (a == 0 || b == 0 || a == 0 && b == 0) {
            return 0;
        }
        int result = 0;
        boolean negativecheck = false;
        if (a < 0 && b > 0 ||a > 0 && b < 0) {
            negativecheck = true;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 0; i < b; i++) {
            result = result + a;
        }
        if (negativecheck) {
            result = result * (- 1);
        }

        return result;
    }

    public int powi(int a, int b) {
        if ( b == 0 ) {
            return 1;
        }
        if ( a == 1 ) {
            return a;
        }
        if (a == 0) {
            return 0;
        }
        if (b < 0) {
            throw new IllegalArgumentException("negative exponent not allowed");
        }
        boolean negativecheck = false;
        int result = 1;
        int counter = 0;

        while (counter < b) {
            result = result * a;
            counter++;
        }

        if (negativecheck) {
            result = result * (- 1);
        }

        return result;
    }

    public int faci(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("negative faculty not allowed");
        }

        if ( a == 1 || a == 0 ) {
            return a;
        }

        int result = 1;
        int counter = 1;
        do {
            result = result * counter;
            counter++;
        } while (counter <= a);

        return result;
    }

    public int fibi(int a) {
        if (a == 0 ||a == 1) {
            return a;
        }

        int[] sequence = new int[a];
        sequence[0] = 0;
        sequence[1] = 1;

        for (int i = 2; i < a; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 1];
        }

        return sequence[a - 1];
    }
}
