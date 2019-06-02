/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.transaction.domain.model.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import py.com.paronline.paronlineapi.user.domain.model.entity.User;

/**
 *
 * @author javie
 */
@XmlRootElement
public class Transaction {

    private int id;
    private Date fecha;
    private User cliente;
    private double total;
    private String direccionEnvio;
    private int idMedioPago;
    private int nroTarjeta;
    private String estado;
    private ArrayList<TransactionDetail> detalles;

    public Transaction() {
        this.id = 0;
        this.fecha = new Date();
        this.cliente = new User();
        this.total = 0;
        this.direccionEnvio = "";
        this.idMedioPago = 0;
        this.nroTarjeta = 0;
        this.estado = "";
        this.detalles = null;
    }

    public Transaction(int id, Date fecha, User cliente, double total, String direccionEnvio, int idMedioPago, int nroTarjeta, String estado, ArrayList<TransactionDetail> detalles) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.idMedioPago = idMedioPago;
        this.nroTarjeta = nroTarjeta;
        this.estado = estado;
        this.detalles = detalles;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlElement
    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    @XmlElement
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @XmlElement
    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    @XmlElement
    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    @XmlElement
    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement
    public ArrayList<TransactionDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<TransactionDetail> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", total=" + total + ", direccionEnvio=" + direccionEnvio + ", idMedioPago=" + idMedioPago + ", nroTarjeta=" + nroTarjeta + ", estado=" + estado + ", detalles=" + detalles + '}';
    }

}
