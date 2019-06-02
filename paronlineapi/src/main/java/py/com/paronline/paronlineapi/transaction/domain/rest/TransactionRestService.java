/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import py.com.paronline.paronlineapi.transaction.domain.model.entity.Transaction;
import py.com.paronline.paronlineapi.transaction.domain.repository.JdbcTransactionRepository;
import py.com.paronline.paronlineapi.transaction.domain.service.TransactionServiceImpl;

/**
 *
 * @author javie
 */
@Path("transactionapi")
public class TransactionRestService {

    private final TransactionServiceImpl transactionService = new TransactionServiceImpl(new JdbcTransactionRepository());

    @GET
    @Path("transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = (ArrayList<Transaction>) transactionService.getAll();
        return transactions;
    }

    @GET
    @Path("transactions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction(@PathParam("id") Integer id) {
        Transaction transaction = null;
        try {
            transaction = transactionService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(TransactionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaction;
    }

    @POST
    @Path("transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction addTransaction(Transaction transaction) {
        try {
            transactionService.add(transaction);
        } catch (Exception ex) {
            Logger.getLogger(TransactionRestService.class.getName()).log(Level.SEVERE, null, ex);
            transaction = null;
        }
        return transaction;
    }

    @PUT
    @Path("transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTransaction(Transaction transaction) {
        try {
            transactionService.update(transaction);
        } catch (Exception ex) {
            Logger.getLogger(TransactionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("transactions/{id}")
    public void removeTransaction(@PathParam("id") Integer id) {
        try {
            transactionService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(TransactionRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
