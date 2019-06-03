/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline.model;

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
    private ProductCategory categoria;
    private double precioUnit;
    private int cantidad;

    public Product() {
        this.id = 0;
        this.descripcion = "";
        this.categoria = new ProductCategory();
        this.precioUnit = 0;
        this.cantidad = 0;
    }

    public Product(int id, String descripcion, ProductCategory categoria, double precioUnit, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
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
    public ProductCategory getCategoria() {
        return categoria;
    }

    public void setCategoria(ProductCategory categoria) {
        this.categoria = categoria;
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
        return "Product{" + "id=" + id + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precioUnit=" + precioUnit + ", cantidad=" + cantidad + '}';
    }

}
