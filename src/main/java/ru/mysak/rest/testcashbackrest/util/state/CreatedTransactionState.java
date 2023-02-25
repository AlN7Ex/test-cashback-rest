package ru.mysak.rest.testcashbackrest.util.state;

import ru.mysak.rest.testcashbackrest.entity.Transaction;

public class CreatedTransactionState implements TransactionState{
    @Override
    public void doAction(Transaction transaction) {
        transaction.setTransactionState(this);
    }
    @Override
    public String getTransactionState() {
        return "Created new transaction";
    }
}
