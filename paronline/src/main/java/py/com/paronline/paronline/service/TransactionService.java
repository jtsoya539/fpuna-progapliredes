/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline.service;

import java.util.ArrayList;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import py.com.paronline.paronline.client.TransactionClient;
import py.com.paronline.paronline.model.Transaction;

/**
 *
 * @author javie
 */
public class TransactionService {

    private static ResteasyClient rClient;
    private static ResteasyWebTarget rWebTarget;
    private static TransactionClient transactionClient;

    public TransactionService() {
        rClient = new ResteasyClientBuilder().build();
        rWebTarget = rClient.target("http://localhost:8080/paronlineapi/rest");
        transactionClient = rWebTarget.proxy(TransactionClient.class);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactionClient.getTransactions();
    }

    public Transaction getTransaction(Integer id) {
        return transactionClient.getTransaction(id);
    }

    public void addTransaction(Transaction transaction) {
        transaction = transactionClient.addTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        transactionClient.updateTransaction(transaction);
    }

    public void removeTransaction(Integer id) {
        transactionClient.removeTransaction(id);
    }

}
