/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.model.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author javie
 */
public class Transaction {

    private int id;
    private Date fecha;
    private int idCliente;
    private double total;
    private String direccionEnvio;
    private int idMedioPago;
    private int nroTarjeta;
    private String Estado;
    private ArrayList<TransactionDetail> detalles;

    public Transaction() {
    }

    public Transaction(int id, Date fecha, int idCliente, double total, String direccionEnvio, int idMedioPago, int nroTarjeta, String Estado, ArrayList<TransactionDetail> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.idMedioPago = idMedioPago;
        this.nroTarjeta = nroTarjeta;
        this.Estado = Estado;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ArrayList<TransactionDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<TransactionDetail> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", fecha=" + fecha + ", idCliente=" + idCliente + ", total=" + total + ", direccionEnvio=" + direccionEnvio + ", idMedioPago=" + idMedioPago + ", nroTarjeta=" + nroTarjeta + ", Estado=" + Estado + ", detalles=" + detalles + '}';
    }

}
