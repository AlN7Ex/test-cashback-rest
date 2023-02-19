package ru.mysak.rest.testcashbackrest.util.state;

public class InProgressTransactionState implements TransactionState{
    @Override
    public String setState() {
        return "Transaction in progress...";
    }
}
