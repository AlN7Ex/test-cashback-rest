package ru.mysak.rest.testcashbackrest.util.state;

import ru.mysak.rest.testcashbackrest.entity.Transaction;

public class ComletedTransactionState implements TransactionState{
    @Override
    public String doAction(Transaction transaction) {
        transaction.setTransactionState(this);
        return "Transaction completed";
    }
}
