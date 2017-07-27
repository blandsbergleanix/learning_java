package net.leanix.bernhard.misc;

public class Recursion {

    public int sum(int a, int b) {
        if ( b == 0 ) {
            return a;
        }
        if ( a == 0 ) {
            return b;
        }

        return sum(a, b - 1) + 1;
    }

    public int prod(int a, int b) {
        if ( b == 1 ) {
            return a;
        }
        if ( a == 1 ) {
            return b;
        }
        if (a == 0 || b == 0) {
            return 0;
        }

        return prod(a, b - 1) + a;
    }

    public int pow(int a, int b) {
        return 0;
    }

    public int fac(int a) {
        return 0;
    }
}
