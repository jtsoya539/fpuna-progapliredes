/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import py.com.paronline.paronlineapi.product.domain.model.entity.Product;
import py.com.paronline.paronlineapi.product.domain.repository.JdbcProductRepository;
import py.com.paronline.paronlineapi.product.domain.service.ProductServiceImpl;

/**
 *
 * @author javie
 */
@Path("productapi")
public class ProductRestService {

    private final ProductServiceImpl productService = new ProductServiceImpl(new JdbcProductRepository());

    @GET
    @Path("products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = (ArrayList<Product>) productService.getAll();
        return products;
    }

    @GET
    @Path("products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") Integer id) {
        Product product = null;
        try {
            product = productService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

    @POST
    @Path("products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        try {
            productService.add(product);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
            product = null;
        }
        return product;
    }

    @PUT
    @Path("products")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(Product product) {
        try {
            productService.update(product);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("products/{id}")
    public void removeProduct(@PathParam("id") Integer id) {
        try {
            productService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
