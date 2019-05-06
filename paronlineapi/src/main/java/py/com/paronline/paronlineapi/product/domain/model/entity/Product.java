/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.product.domain.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author javie
 */
@XmlRootElement
public class Product {

    private int id;
    private String descripcion;
    private int idCategoria;
    private double precioUnit;
    private int cantidad;

    public Product() {
    }

    public Product(int id, String descripcion, int idCategoria, double precioUnit, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.precioUnit = precioUnit;
        this.cantidad = cantidad;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElement
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlElement
    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", descripcion=" + descripcion + ", idCategoria=" + idCategoria + ", precioUnit=" + precioUnit + ", cantidad=" + cantidad + '}';
    }

}
