/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    // private final TransactionServiceImpl transactionService = new TransactionServiceImpl(new JdbcTransactionRepository());
    @GET
    @Path("transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getUsers() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(56, null, 100, 256000, "Asunción", 0, 0, null, null));
        transactions.add(new Transaction(58, null, 100, 23000, "Luque", 0, 0, null, null));
        return transactions;
    }

}
