/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        ArrayList<Product> products = (ArrayList) productService.getAll();
        return products;
    }

    @GET
    @Path("products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") Integer id) {
        Product entity = null;
        try {
            entity = (Product) productService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
}
