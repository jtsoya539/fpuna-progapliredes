/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.model.entity;

/**
 *
 * @author javie
 */
public class TransactionDetail {

    private int idTransaccion;
    private int item;
    private int idProducto;
    private int cantidad;
    private double precio;
    private double subTotal;

    public TransactionDetail() {
    }

    public TransactionDetail(int idTransaccion, int item, int idProducto, int cantidad, double precio, double subTotal) {
        this.idTransaccion = idTransaccion;
        this.item = item;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" + "idTransaccion=" + idTransaccion + ", item=" + item + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precio=" + precio + ", subTotal=" + subTotal + '}';
    }

}
