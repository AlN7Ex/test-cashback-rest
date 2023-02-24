package ru.mysak.rest.testcashbackrest.util.state;

import ru.mysak.rest.testcashbackrest.entity.Transaction;

public class FailedTransactionState implements TransactionState{
    @Override
    public String doAction(Transaction transaction) {
        transaction.setTransactionState(this);
        return "Failed transaction";
    }
}
