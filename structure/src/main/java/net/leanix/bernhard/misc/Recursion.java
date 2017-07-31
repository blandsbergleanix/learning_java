package net.leanix.bernhard.misc;

import jdk.nashorn.internal.ir.IfNode;

public class Recursion {

    public int sum(int a, int b) {
        if ( b == 0 ) {
            return a;
        }
        if ( a == 0 ) {
            return b;
        }

        if (b < 0) {
            return sum(a, b + 1) - 1;
        } else {
            return sum(a, b - 1) + 1;
        }
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

        if (a < 0 && b < 0) {
            // both numbers negative
            a = Math.abs(a);
            b = Math.abs(b);
        } else if (a < 0 || b < 0) {
            // only one number negative
            a = Math.abs(a);
            b = Math.abs(b);
            return (prod(a, b - 1) + a) * (- 1);
        }

        return prod(a, b - 1) + a;
    }

    public int pow(int a, int b) {
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
        if (a < 0 && b % 2 != 0) {
            a = Math.abs(a);
            negativecheck = true;
        }

        if (negativecheck) {
            return (pow(a, b - 1) * a) * (- 1);
        }
        return pow(a, b - 1) * a;
    }

    public int fac(int a) {
        if (a < 0) {
            return a;
        }

        if ( a == 1 || a == 0 ) {
            return a;
        }

        return fac(a - 1) * a;
    }
}
