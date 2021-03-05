package by.gomel.novik.library.persistance.transaction;

import by.gomel.novik.library.model.entity.Entity;
import by.gomel.novik.library.persistance.transaction.process.TransactionProcess;


public interface TransactionManager<T extends Entity>  {


    T doInTransaction(TransactionProcess<T> process, TransactionCommand command);
}
