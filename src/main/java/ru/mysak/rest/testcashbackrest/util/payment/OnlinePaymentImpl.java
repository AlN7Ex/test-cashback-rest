package ru.mysak.rest.testcashbackrest.util.payment;

import org.springframework.stereotype.Component;

@Component
public class OnlinePaymentImpl implements Payment {
    private final int priceLessThen20 = 20;
    private final double commissionPriceLessThen20 = 0.1;
    private final int priceAtLeast300 = 300;
    private final double cashbackPriceAtLeast300 = 0.3;

    private final double commonCashbackPercent = 0.17;
    @Override
    public double doPayment(double price) {
        if (price < priceLessThen20)
        {
            return price * commissionPriceLessThen20;
        }
        else if (price > priceAtLeast300) {
            return price * cashbackPriceAtLeast300;
        }

        return price * commonCashbackPercent;
    }
}
