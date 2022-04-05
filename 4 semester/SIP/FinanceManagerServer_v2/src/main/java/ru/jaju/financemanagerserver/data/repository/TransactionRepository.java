package ru.jaju.financemanagerserver.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jaju.financemanagerserver.data.transaction.Transaction;
import ru.jaju.financemanagerserver.data.transaction.TransactionId;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, TransactionId> {

    List<Transaction> findTransactionByTransactionIdUserId(@NotNull int userId);

    Optional<Transaction> findTransactionByTransactionIdTransIdAndTransactionIdUserId(@NotNull String transId, @NotNull int userId);

    //Optional<Transaction> findTransactionByTransactionIdTransIdAndCategoryCategoryIdCatId(@NotNull String transId, String categoryId);

    @Transactional
    void deleteTransactionByTransactionIdTransIdAndTransactionIdUserId(@NotNull String transId, @NotNull int userId);
    //List<Transaction> findTransactionsByIdIn(@NonNull List<Integer> ids);*/

    @Transactional
    void deleteTransactionsByTransactionIdTransIdInAndTransactionIdUserId(@NotNull List<String> transIds, @NotNull int userId);
}
