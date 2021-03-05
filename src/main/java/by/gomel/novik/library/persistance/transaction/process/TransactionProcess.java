package by.gomel.novik.library.persistance.transaction.process;

import by.gomel.novik.library.model.entity.Entity;
import by.gomel.novik.library.persistance.transaction.TransactionCommand;

import java.util.concurrent.Callable;

public interface TransactionProcess<T extends Entity> {


    T process(T t, TransactionCommand command);

}
