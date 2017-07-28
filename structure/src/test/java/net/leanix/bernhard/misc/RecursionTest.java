package net.leanix.bernhard.misc;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursionTest {
    private Recursion r;

    @Before
    public void setUp() throws Exception {
       r = new Recursion();
    }

    @Test
    public void sum_0And0() {
        // given
        int a = 0;
        int b = 0;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(0);
    }

    @Test
    public void sum_0And1() {
        // given
        int a = 0;
        int b = 1;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(1);
    }

    @Test
    public void sum_1And1() {
        // given
        int a = 1;
        int b = 1;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(2);
    }

    @Test
    public void sum_1And0() {
        // given
        int a = 1;
        int b = 0;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(1);
    }

    @Test
    public void sum_1And2() {
        // given
        int a = 1;
        int b = 2;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(3);
    }

    @Test
    public void sum_minus4And2() {
        // given
        int a = -4;
        int b = 2;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(-2);
    }

    @Test
    public void sum_1AndMinus4() {
        // given
        int a = 1;
        int b = -4;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(-3);
    }

    @Test
    public void sum_Minus1AndMinus2() {
        // given
        int a = -1;
        int b = -2;

        // when
        int s = r.sum(a, b);

        // then
        assertThat(s).isEqualTo(-3);
    }


    @Test
    public void times_0And0() {
        // given
        int a = 0;
        int b = 0;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(0);
    }

    @Test
    public void times_0And1() {
        // given
        int a = 0;
        int b = 1;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(0);
    }

    @Test
    public void times_1And0() {
        // given
        int a = 1;
        int b = 0;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(0);
    }

    @Test
    public void times_1And1() {
        // given
        int a = 1;
        int b = 1;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(1);
    }

    @Test
    public void times_1And2() {
        // given
        int a = 1;
        int b = 2;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(2);
    }

    @Test
    public void times_2And1() {
        // given
        int a = 2;
        int b = 1;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(2);
    }

    @Test
    public void times_6And7() {
        // given
        int a = 6;
        int b = 7;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(42);
    }

    @Test
    public void times_Minus6And7() {
        // given
        int a = -6;
        int b = 7;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(-42);
    }

    @Test
    public void times_Minus6AndMinus7() {
        // given
        int a = -6;
        int b = -7;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(42);
    }

    @Test
    public void times_6AndMinus7() {
        // given
        int a = 6;
        int b = -7;

        // when
        int p = r.prod(a, b);

        // then
        assertThat(p).isEqualTo(-42);
    }

    // TODO: add other reasonable tests

    @Test
    public void pow_2And8() {
        // given
        int a = 2;
        int b = 8;

        // when
        int p = r.pow(a, b);

        // then
        assertThat(p).isEqualTo(256);
    }

    @Test
    public void pow_Minus2And8() {
        // given
        int a = -2;
        int b = 8;

        // when
        int p = r.pow(a, b);

        // then
        assertThat(p).isEqualTo(-256);
    }

    @Test
    public void pow_2AndMinus8_ShouldDoNothing() {
        // given
        int a = 2;
        int b = -8;

        // when
        int p = r.pow(a, b);

        // then
        assertThat(p).isEqualTo(a);
    }


    // TODO: add other reasonable tests

    @Test
    public void fac_10() {
        // given
        int a = 10;

        // when
        int f = r.fac(a);

        // then
        assertThat(f).isEqualTo(3628800);
    }

    @Test
    public void fac_Minus10_ShouldDoNothing() {
        // given
        int a = -10;

        // when
        int f = r.fac(a);

        // then
        assertThat(f).isEqualTo(- 10);
    }

    @Test
    public void fac_Minus0() {
        // given
        int a = 0;

        // when
        int f = r.fac(a);

        // then
        assertThat(f).isEqualTo(0);
    }
}