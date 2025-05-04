package management;

import datastructures.lists.CustomArrayList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
       this.transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        for (int i = 0; i < transactions.size(); i++) {
            if(i == index)
                return transactions.get(i);
        }
        return null;
    }
}
