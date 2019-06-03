/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline.client;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import py.com.paronline.paronline.model.Transaction;

/**
 *
 * @author javie
 */
@Path("transactionapi")
public interface TransactionClient {

    @GET
    @Path("transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getTransactions();

    @GET
    @Path("transactions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction(@PathParam("id") Integer id);

    @POST
    @Path("transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction addTransaction(Transaction transaction);

    @PUT
    @Path("transactions")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTransaction(Transaction transaction);

    @DELETE
    @Path("transactions/{id}")
    public void removeTransaction(@PathParam("id") Integer id);

}
