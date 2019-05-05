/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi;

import py.com.paronline.paronlineapi.product.domain.model.entity.Product;
import py.com.paronline.paronlineapi.product.domain.repository.JdbcProductRepository;
import py.com.paronline.paronlineapi.product.domain.service.ProductServiceImpl;
import py.com.paronline.paronlineapi.user.domain.model.entity.User;
import py.com.paronline.paronlineapi.user.domain.repository.JdbcUserRepository;
import py.com.paronline.paronlineapi.user.domain.service.UserServiceImpl;

/**
 *
 * @author javie
 */
public class Program {

    public static void main(String[] args) throws Exception {
        UserServiceImpl userService = new UserServiceImpl(new JdbcUserRepository());
        User user = new User(6, "Ruffus", "Meza", "ruffus@shitzhu.com", "ruffito", "123456", 0);
        //userService.add(user);

        ProductServiceImpl productService = new ProductServiceImpl(new JdbcProductRepository());
        Product product = new Product(4, "Samsung Galaxy S10", 2, 4800000, 2);
        productService.add(product);
        //productService.update(product);
        //productService.delete(1);
    }

}
