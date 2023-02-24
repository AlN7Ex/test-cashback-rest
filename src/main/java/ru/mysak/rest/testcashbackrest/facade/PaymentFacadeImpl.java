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
import ru.mysak.rest.testcashbackrest.util.state.TransactionStateFactory;

@Service
@AllArgsConstructor
public class PaymentFacadeImpl implements PaymentFacade {
    private final BillServiceImpl billService;
    private final TransactionServiceImpl transactionService;
    private final PaymentServiceFactory paymentService;
    private final TransactionStateFactory stateFactory;


    @Override
    public boolean onlinePayment(Long client_id, int price) {
        if (billService.readByClientId(client_id) == null) {
            return false;
        }
        Bill bill = billService.readByClientId(client_id);

        Transaction transaction = new Transaction(bill);
        transactionService.create(transaction);
        transactionService.update(transaction, stateFactory.getState(TransactionalStateType.PROGRESS));
        if (bill.getDeposit() < price) {
            transactionService.update(transaction, stateFactory.getState(TransactionalStateType.FAILED));
            return false;
        }
        paymentService.doOperation(bill, price, PaymentType.ONLINE);
        billService.update(bill);

        transactionService.update(transaction, stateFactory.getState(TransactionalStateType.COMPLETED));

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
        transactionService.update(transaction, stateFactory.getState(TransactionalStateType.PROGRESS));
        if (bill.getDeposit() < price) {
            transactionService.update(transaction, stateFactory.getState(TransactionalStateType.FAILED));
            return false;
        }
        paymentService.doOperation(bill, price, PaymentType.ONLINE);
        billService.update(bill);
        transactionService.update(transaction, stateFactory.getState(TransactionalStateType.COMPLETED));

        return true;
    }
}
