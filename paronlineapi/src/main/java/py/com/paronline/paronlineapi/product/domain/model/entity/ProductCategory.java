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
public class ProductCategory {

    private int id;
    private String descripcion;

    public ProductCategory() {
        this.id = 0;
        this.descripcion = "";
    }

    public ProductCategory(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "ProductCategory{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }

}
