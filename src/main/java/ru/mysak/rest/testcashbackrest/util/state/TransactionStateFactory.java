package ru.mysak.rest.testcashbackrest.util.state;

import org.springframework.stereotype.Component;
import ru.mysak.rest.testcashbackrest.TransactionalStateType;

@Component
public class TransactionStateFactory {

    public TransactionState getState(TransactionalStateType state) {
        return switch (state) {
            case PROGRESS -> new InProgressTransactionState();
            case COMPLETED -> new ComletedTransactionState();
            case FAILED -> new FailedTransactionState();
        };
    }


}
