package ru.mysak.rest.testcashbackrest.util.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class OnlinePaymentImplTest {

    @Test
    public void doPayment1() {
        double deposit = 5000;
        double expected = 10;
        double actual = new OnlinePaymentImpl().doPayment(100);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment2() {
        double deposit = 5000;
        double expected = 90.3;
        double actual = new OnlinePaymentImpl().doPayment(301);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment3() {
        double deposit = 5000;
        double expected = 1.7;
        double actual = new OnlinePaymentImpl().doPayment(17);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment4() {
        double deposit = 5000;
        double expected = 3.57;
        double actual = new OnlinePaymentImpl().doPayment(21);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment5() {
        double deposit = 5000;
        double expected = 210;
        double actual = new OnlinePaymentImpl().doPayment(700);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment6() {
        double deposit = 5000;
        double expected = 0;
        double actual = new OnlinePaymentImpl().doPayment(6000);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
}