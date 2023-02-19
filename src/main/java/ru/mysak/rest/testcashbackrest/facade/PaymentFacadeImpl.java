package ru.mysak.rest.testcashbackrest.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.entity.Bill;
import ru.mysak.rest.testcashbackrest.entity.Transaction;
import ru.mysak.rest.testcashbackrest.service.BillServiceImpl;
import ru.mysak.rest.testcashbackrest.service.ClientServiceImpl;
import ru.mysak.rest.testcashbackrest.service.TransactionServiceImpl;
import ru.mysak.rest.testcashbackrest.util.payment.OfflineShopPaymentImpl;
import ru.mysak.rest.testcashbackrest.util.payment.OnlinePaymentImpl;
import ru.mysak.rest.testcashbackrest.util.state.ComletedTransactionState;
import ru.mysak.rest.testcashbackrest.util.state.CreatedTransactionState;
import ru.mysak.rest.testcashbackrest.util.state.InProgressTransactionState;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PaymentFacadeImpl implements PaymentFacade{

    private final ClientServiceImpl clientService;
    private final BillServiceImpl billService;
    private final TransactionServiceImpl transactionService;

    private final OnlinePaymentImpl onlinePayment;
    private final OfflineShopPaymentImpl offlineShopPayment;


    @Override
    @Transactional
    public boolean onlinePayment(Long client_id, int price) {
        if (billService.readByClientId(client_id) == null
                || billService.readByClientId(client_id).getDeposit() < price) {
            return false;
        }
        Bill bill = billService.readByClientId(client_id);
        Transaction transaction = new Transaction(bill, new CreatedTransactionState().setState());
        transactionService.create(transaction);
        transaction.setState(new InProgressTransactionState().setState());
        transactionService.update(transaction);
        double paymentResult = onlinePayment.doPayment(price);
        bill.setDeposit(bill.getDeposit() - price);
        bill.setCashback(bill.getCashback() + paymentResult);
        billService.update(bill);
        transaction.setState(new ComletedTransactionState().setState());
        transactionService.update(transaction);
        return true;
    }

    @Override
    public boolean offlineShopPayment(Long client_id, int price) {
        if (billService.readByClientId(client_id) == null
                || billService.readByClientId(client_id).getDeposit() < price) {
            return false;
        }
        Bill bill = billService.readByClientId(client_id);
        Transaction transaction = new Transaction(bill, new CreatedTransactionState().setState());
        transactionService.create(transaction);
        transaction.setState(new InProgressTransactionState().setState());
        transactionService.update(transaction);
        double paymentResult = offlineShopPayment.doPayment(price);
        bill.setDeposit(bill.getDeposit() - price);
        bill.setCashback(bill.getCashback() + paymentResult);
        billService.update(bill);
        transaction.setState(new ComletedTransactionState().setState());
        transactionService.update(transaction);
        return true;
    }
}
