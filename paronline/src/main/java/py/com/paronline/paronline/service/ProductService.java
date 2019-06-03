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
import py.com.paronline.paronline.client.ProductClient;
import py.com.paronline.paronline.model.Product;

/**
 *
 * @author javie
 */
public class ProductService {

    private static ResteasyClient rClient;
    private static ResteasyWebTarget rWebTarget;
    private static ProductClient productClient;

    public ProductService() {
        rClient = new ResteasyClientBuilder().build();
        rWebTarget = rClient.target("http://localhost:8080/paronlineapi/rest");
        productClient = rWebTarget.proxy(ProductClient.class);
    }

    public ArrayList<Product> getProducts() {
        return productClient.getProducts();
    }

    public Product getProduct(Integer id) {
        return productClient.getProduct(id);
    }

    public void addProduct(Product product) {
        product = productClient.addProduct(product);
    }

    public void updateProduct(Product product) {
        productClient.updateProduct(product);
    }

    public void removeProduct(Integer id) {
        productClient.removeProduct(id);
    }

}
