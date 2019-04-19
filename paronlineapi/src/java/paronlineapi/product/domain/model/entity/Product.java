/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.product.domain.model.entity;

import paronlineapi.common.domain.model.entity.BaseEntity;

/**
 *
 * @author javie
 */
public class Product extends BaseEntity<Integer> {

    private int idCategoria;
    private double precioUnit;
    private int cantidad;

    public Product() {
        super(0, "Sin nombre");
    }

    public Product(Integer id, String nombre) {
        super(id, nombre);
    }

    public Product(Integer id, String nombre, int idCategoria, double precioUnit, int cantidad) {
        super(id, nombre);
        this.idCategoria = idCategoria;
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Product{" + "idCategoria=" + idCategoria + ", precioUnit=" + precioUnit + ", cantidad=" + cantidad + '}';
    }

}
