package ru.mysak.rest.testcashbackrest.util.state;

public class CreatedTransactionState implements TransactionState{
    @Override
    public String setState() {
        return "Created new transaction";
    }
}
