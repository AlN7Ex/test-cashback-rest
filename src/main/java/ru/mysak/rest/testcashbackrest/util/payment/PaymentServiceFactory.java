package ru.mysak.rest.testcashbackrest.util.payment;

import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.PaymentType;
import ru.mysak.rest.testcashbackrest.entity.Bill;

@Service
public class PaymentServiceFactory {
    public boolean doOperation(Bill bill, double price, PaymentType paymentType) {
        double cashback = 0;
        switch (paymentType) {
            case ONLINE -> {
                cashback = new OnlinePaymentImpl().doPayment(price);
                bill.setDeposit(bill.getDeposit() - price);
                bill.setCashback(bill.getCashback() + cashback);
                return true;
            }
            case OFFLINE -> {
                cashback = new OfflineShopPaymentImpl().doPayment(price);
                bill.setDeposit(bill.getDeposit() - price);
                bill.setCashback(bill.getCashback() + cashback);
                return true;
            }
        }
        return false;
    }
}
