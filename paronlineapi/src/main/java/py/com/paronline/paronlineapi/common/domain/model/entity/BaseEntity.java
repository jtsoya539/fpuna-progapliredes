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
public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    public BaseEntity() {
    }

    public BaseEntity(T id, String nombre) {
        super(id, nombre);
        this.isModified = false;
    }

    public boolean isIsModified() {
        return isModified;
    }

}
