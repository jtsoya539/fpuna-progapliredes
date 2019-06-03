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
import py.com.paronline.paronline.model.Product;

/**
 *
 * @author javie
 */
@Path("productapi")
public interface ProductClient {

    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProducts();

    @GET
    @Path("products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") Integer id);

    @POST
    @Path("products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product);

    @PUT
    @Path("products")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product product);

    @DELETE
    @Path("products/{id}")
    public void removeProduct(@PathParam("id") Integer id);

}
