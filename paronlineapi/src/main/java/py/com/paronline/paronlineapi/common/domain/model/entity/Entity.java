/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.common.domain.model.entity;

/**
 *
 * @author javie
 * @param <T>
 */
public abstract class Entity<T> {

    T id;
    String nombre;

    public Entity() {
    }

    public Entity(T id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
