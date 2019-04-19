/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.product.domain.repository;

import java.util.Collection;
import paronlineapi.common.domain.repository.Repository;
import paronlineapi.product.domain.model.entity.Product;

/**
 *
 * @author javie
 */
public interface ProductRepository extends Repository<Product, Integer> {

    public boolean containsNombre(String nombre);

    public boolean containsIdCategoria(int idCategoria);

    public boolean containsPrecioUnit(double precioUnit);

    public Collection<Product> findByNombre(String nombre) throws Exception;

    public Collection<Product> findByIdCategoria(int idCategoria) throws Exception;

    public Collection<Product> findByPrecioUnit(double precioUnit) throws Exception;

}
