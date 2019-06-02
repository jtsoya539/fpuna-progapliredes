/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.repository;

import java.util.Collection;
import py.com.paronline.paronlineapi.common.domain.repository.Repository;
import py.com.paronline.paronlineapi.product.domain.model.entity.Product;
import py.com.paronline.paronlineapi.product.domain.model.entity.ProductCategory;

/**
 *
 * @author javie
 */
public interface ProductRepository extends Repository<Product, Integer> {

    public boolean containsDescripcion(String descripcion);

    public boolean containsCategoria(ProductCategory categoria);

    public boolean containsPrecioUnit(double precioUnit);

    public Collection<Product> findByDescripcion(String descripcion) throws Exception;

    public Collection<Product> findByCategoria(ProductCategory categoria) throws Exception;

    public Collection<Product> findByPrecioUnit(double precioUnit) throws Exception;

}
