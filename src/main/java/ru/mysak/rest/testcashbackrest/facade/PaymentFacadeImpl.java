package ru.mysak.rest.testcashbackrest.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mysak.rest.testcashbackrest.PaymentType;
import ru.mysak.rest.testcashbackrest.TransactionalStateType;
import ru.mysak.rest.testcashbackrest.entity.Bill;
import ru.mysak.rest.testcashbackrest.entity.Transaction;
import ru.mysak.rest.testcashbackrest.service.BillServiceImpl;
import ru.mysak.rest.testcashbackrest.service.TransactionServiceImpl;
import ru.mysak.rest.testcashbackrest.util.payment.PaymentServiceFactory;

@Service
@AllArgsConstructor
public class PaymentFacadeImpl implements PaymentFacade {
    private final BillServiceImpl billService;
    private final TransactionServiceImpl transactionService;
    private final PaymentServiceFactory paymentService;

    @Override
    public boolean onlinePayment(Long client_id, int price) {
        if (billService.readByClientId(client_id) == null) {
            return false;
        }
        Bill bill = billService.readByClientId(client_id);

        Transaction transaction = new Transaction(bill);
        transactionService.create(transaction);
        transactionService.update(transaction, TransactionalStateType.PROGRESS);
        if (bill.getDeposit() < price) {
            transactionService.update(transaction, TransactionalStateType.FAILED);
            return false;
        }
        paymentService.doOperation(bill, price, PaymentType.ONLINE);
        billService.update(bill);

        transactionService.update(transaction, TransactionalStateType.COMPLETED);

        return true;
    }

    @Override
    public boolean offlineShopPayment(Long client_id, int price) {
        if (billService.readByClientId(client_id) == null) {
            return false;
        }
        Bill bill = billService.readByClientId(client_id);

        Transaction transaction = new Transaction(bill);
        transactionService.create(transaction);
        transactionService.update(transaction, TransactionalStateType.PROGRESS);
        if (bill.getDeposit() < price) {
            transactionService.update(transaction, TransactionalStateType.FAILED);
            return false;
        }
        paymentService.doOperation(bill, price, PaymentType.ONLINE);
        billService.update(bill);
        transactionService.update(transaction, TransactionalStateType.COMPLETED);

        return true;
    }
}
