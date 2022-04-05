package ru.jaju.financemanagerserver.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.jaju.financemanagerserver.data.transaction.Transaction;
import ru.jaju.financemanagerserver.data.repository.TransactionRepository;
import ru.jaju.financemanagerserver.exception.TransactionNotFoundExcpetion;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//TODO: change duplicated
@SuppressWarnings("Duplicates")
@RestController
@RequestMapping(value = "/api/transaction",produces = "application/json")
public class TransactionController {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction, @AuthenticationPrincipal String userId) {
        transaction.getTransactionId().setUserId(Integer.parseInt(userId));
        transactionRepository.save(transaction);
    }

    @PostMapping("/list")
    public void addTransactions(@RequestBody List<Transaction> transactions, @AuthenticationPrincipal String userId) {
        transactions.forEach(category -> category.getTransactionId().setUserId(Integer.parseInt(userId)));
        transactionRepository.saveAll(transactions);
    }


    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable("id") String transactionId, @AuthenticationPrincipal String userId) {
        return transactionRepository.findTransactionByTransactionIdTransIdAndTransactionIdUserId(transactionId, Integer.parseInt(userId))
                .orElseThrow(TransactionNotFoundExcpetion::new);
    }

    @GetMapping("/list")
    public List<Transaction> getTransactions(@AuthenticationPrincipal String userId) {
        return transactionRepository.findTransactionByTransactionIdUserId(Integer.parseInt(userId));
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") String transId, @AuthenticationPrincipal String userId) {
        transactionRepository.deleteTransactionByTransactionIdTransIdAndTransactionIdUserId(transId, Integer.parseInt(userId));
    }

    @DeleteMapping("/list")
    public void deleteTransactions(HttpServletRequest request, @AuthenticationPrincipal String userId) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        List<String> ids = new LinkedList<>();
        jsonObject.getAsJsonArray("transactions_id").forEach(jsonElement ->
                ids.add(jsonElement.getAsString()));
        transactionRepository.deleteTransactionsByTransactionIdTransIdInAndTransactionIdUserId(ids, Integer.parseInt(userId));
    }

   /* @PutMapping("/{catId}")
    public void changeTransaction(@PathVariable("catId") int catId, HttpServletRequest request) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null) {
            throw new WrongJsonException();
        }
        Transaction transactionBd = transactionRepository.findById(catId).orElseThrow(TransactionNotFoundExcpetion::new);
        if (jsonObject.has("amount")) {
            transactionBd.setAmount(jsonObject.get("amount").getAsInt());
        }
        if (jsonObject.has("note")) {
            transactionBd.setNote(jsonObject.get("note").getAsString());
        }
        if (jsonObject.has("date_time")) {
            transactionBd.setLastUpdate(new Timestamp(jsonObject.get("date_time").getAsLong()));
        }
        if (jsonObject.has("category_id")) {
            categoryRepository.findById(jsonObject.get("category_id").getAsInt()).orElseThrow(CategoryNotFoundExcpetion::new);
        }
        transactionRepository.save(transactionBd);
    }*/

  /*  @PutMapping("/list")
    public void changeTransactions(HttpServletRequest request) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null) {
            throw new WrongJsonException();
        }
        if (jsonObject.has("ids") && jsonObject.has("transactions")) {
            List<Integer> ids = new LinkedList<>();
            JsonArray jsonObjects = jsonObject.getAsJsonArray("transactions");
            jsonObject.getAsJsonArray("ids").forEach(jsonElement -> ids.add(jsonElement.getAsInt()));
            List<Transaction> transactionsDb = transactionRepository.findTransactionsByIdIn(ids);
            IntStream.range(0, transactionsDb.size()).forEach(catId -> {
                Transaction transaction = transactionsDb.get(catId);
                JsonObject transactionJson = jsonObjects.get(catId).getAsJsonObject();
                if (transactionJson.has("amount")) {
                    transaction.setAmount(transactionJson.get("amount").getAsInt());
                }
                if (transactionJson.has("note")) {
                    transaction.setNote(transactionJson.get("note").getAsString());
                }
                if (transactionJson.has("date_time")) {
                    transaction.setLastUpdate(new Timestamp(transactionJson.get("date_time").getAsLong()));
                }
                if (transactionJson.has("category_id")) {
                    categoryRepository.findById(transactionJson.get("category_id").getAsInt()).orElseThrow(CategoryNotFoundExcpetion::new);
                }
            });
            transactionRepository.saveAll(transactionsDb);
        } else {
            throw new WrongJsonException();
        }
    }*/
}