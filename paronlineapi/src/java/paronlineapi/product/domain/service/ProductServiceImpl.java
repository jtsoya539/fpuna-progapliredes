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
import paronlineapi.common.domain.service.BaseService;
import paronlineapi.product.domain.model.entity.Product;
import paronlineapi.product.domain.repository.ProductRepository;

/**
 *
 * @author javie
 */
public class ProductServiceImpl extends BaseService<Product, Integer> implements ProductService {
    
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
    
    @Override
    public void add(Product product) throws Exception {
        if (this.productRepository.containsNombre(product.getNombre())) {
            throw new Exception(String.format("Ya existe un producto con la descripcion %s", product.getNombre()));
        }
        
        if (product.getNombre() == null || "".equals(product.getNombre())) {
            throw new Exception("La descripcion del producto no puede ser nulo o cadena vacia.");
        }
        
        super.add(product);
    }
    
    @Override
    public void update(Product product) throws Exception {
        this.productRepository.update(product);
    }
    
    @Override
    public void delete(Integer id) throws Exception {
        this.productRepository.remove(id);
    }
    
    @Override
    public Entity findById(Integer id) throws Exception {
        return this.productRepository.get(id);
    }
    
    @Override
    public Collection<Product> findByNombre(String nombre) throws Exception {
        return this.productRepository.findByNombre(nombre);
    }
    
    @Override
    public Collection<Product> findByIdCategoria(int idCategoria) throws Exception {
        return this.productRepository.findByIdCategoria(idCategoria);
    }
    
    @Override
    public Collection<Product> findByPrecioUnit(double precioUnit) throws Exception {
        return this.findByPrecioUnit(precioUnit);
    }
    
    @Override
    public Collection<Product> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
