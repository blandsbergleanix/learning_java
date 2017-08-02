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
            throw new IllegalArgumentException("negative faculty not allowed");
        }

        if ( a == 1 || a == 0 ) {
            return a;
        }

        return fac(a - 1) * a;
    }

    private int fibcounter(int a, int[] counter, int[] memory) {
        if (memory[a] > - 1) {
            return memory[a];
        }

        counter[a]++;
        int result;
        if (a == 0) {
            result = 0;
        } else if (a == 1 || a == 2) {
            result = 1;
        } else {
            result = fibcounter(a - 1, counter, memory) + fibcounter(a - 2, counter, memory);
        }
        memory[a] = result;
        return result;
    }

    private void output(int[] counter) {
        long total = 0;
        for (int i = 0; i < counter.length; i++) {
            System.out.println("Fib(" + i + ")" + ": " + counter[i]);
            total = total + counter[i];
        }
        System.out.println("Total: " + total);
    }


    public int fib(int a) {

        int[] counter = new int[a + 1];
        int[] memory = new int[a + 1];

        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
            memory[i] = -1;
        }

        int result = fibcounter(a, counter, memory);
        output(counter);
        return result;
    }

}
