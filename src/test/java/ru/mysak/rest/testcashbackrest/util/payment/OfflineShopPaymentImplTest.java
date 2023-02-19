package ru.mysak.rest.testcashbackrest.util.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class OfflineShopPaymentImplTest {

    @Test
    public void doPayment1() {
        double deposit = 5000;
        double expected = 12;
        double actual = new OnlinePaymentImpl().doPayment(120);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment2() {
        double deposit = 5000;
        double expected = 300;
        double actual = new OfflineShopPaymentImpl().doPayment(1000);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }

    @Test
    public void doPayment3() {
        double deposit = 5000;
        double expected = 171;
        double actual = new OfflineShopPaymentImpl().doPayment(570);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
    @Test
    public void doPayment4() {
        double deposit = 5000;
        double expected = 0;
        double actual = new OfflineShopPaymentImpl().doPayment(6000);
        assertEquals(expected, actual, Math.abs(expected - actual));
    }
}