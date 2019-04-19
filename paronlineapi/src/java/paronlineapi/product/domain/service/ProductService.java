/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.product.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import paronlineapi.common.domain.model.entity.Entity;
import paronlineapi.product.domain.model.entity.Product;

/**
 *
 * @author javie
 */
public interface ProductService {

    public void add(Product product) throws Exception;

    public void update(Product product) throws Exception;

    public void delete(Integer id) throws Exception;

    public Entity findById(Integer id) throws Exception;

    public Collection<Product> findByNombre(String nombre) throws Exception;

    public Collection<Product> findByIdCategoria(int idCategoria) throws Exception;

    public Collection<Product> findByPrecioUnit(double precioUnit) throws Exception;

    public Collection<Product> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}