/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.user.domain.model.entity;

import paronlineapi.common.domain.model.entity.BaseEntity;

/**
 *
 * @author javie
 */
public class User extends BaseEntity<Integer> {

    private String apellido;
    private String email;
    private String loginName;
    private String passwd;
    private int tipoCliente;

    public User() {
        super(0, "Sin nombre");
    }

    public User(Integer id, String nombre) {
        super(id, nombre);
    }

    public User(Integer id, String nombre, String apellido, String email, String loginName, String passwd, int tipoCliente) {
        super(id, nombre);
        this.apellido = apellido;
        this.email = email;
        this.loginName = loginName;
        this.passwd = passwd;
        this.tipoCliente = tipoCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "User{" + "apellido=" + apellido + ", email=" + email + ", loginName=" + loginName + ", passwd=" + passwd + ", tipoCliente=" + tipoCliente + '}';
    }

}
