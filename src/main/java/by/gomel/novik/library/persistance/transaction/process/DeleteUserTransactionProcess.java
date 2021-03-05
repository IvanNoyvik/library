package by.gomel.novik.library.persistance.transaction.process;

import by.gomel.novik.library.model.User;
import by.gomel.novik.library.model.entity.Entity;
import by.gomel.novik.library.persistance.transaction.TransactionCommand;

public class DeleteUserTransactionProcess implements TransactionProcess<User> {

    @Override
    public User process(User User, TransactionCommand command) {
        return null;
    }
}
