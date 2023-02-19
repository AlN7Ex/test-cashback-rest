package ru.mysak.rest.testcashbackrest.util.payment;

import org.springframework.stereotype.Component;

@Component
public class OfflineShopPaymentImpl implements Payment {

    private final int PRICE_LESS_THEN_20 = 20;
    private final double PERCENTS_PRICE_LESS_THEN_20 = 0.1;
    private final int PRICE_AT_LEAST_300 = 300;
    private final double PERCENTS_PRICE_AT_LEAST_300 = 0.3;

    private final double COMMON_CASHBACK_PERCENTS = 0.1;
    @Override
    public double doPayment(double price) {
        if (price < PRICE_LESS_THEN_20)
        {
            return price * PERCENTS_PRICE_LESS_THEN_20;
        }
        else if (price > PRICE_AT_LEAST_300) {
            return price * PERCENTS_PRICE_AT_LEAST_300;
        }

        return price * COMMON_CASHBACK_PERCENTS;
    }
}
