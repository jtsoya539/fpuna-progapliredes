/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import py.com.paronline.paronlineapi.product.domain.model.entity.Product;

/**
 *
 * @author javie
 */
@XmlRootElement
public class TransactionDetail {

    private int idTransaccion;
    private int item;
    private Product producto;
    private int cantidad;
    private double precio;
    private double subTotal;

    public TransactionDetail() {
        this.idTransaccion = 0;
        this.item = 0;
        this.producto = new Product();
        this.cantidad = 0;
        this.precio = 0;
        this.subTotal = 0;
    }

    public TransactionDetail(int idTransaccion, int item, Product producto, int cantidad, double precio, double subTotal) {
        this.idTransaccion = idTransaccion;
        this.item = item;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    @XmlElement
    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @XmlElement
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @XmlElement
    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @XmlElement
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlElement
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" + "idTransaccion=" + idTransaccion + ", item=" + item + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ", subTotal=" + subTotal + '}';
    }

}
