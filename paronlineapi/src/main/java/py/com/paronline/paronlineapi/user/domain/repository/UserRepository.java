/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.user.domain.repository;

import java.util.Collection;
import py.com.paronline.paronlineapi.common.domain.repository.Repository;
import py.com.paronline.paronlineapi.user.domain.model.entity.User;

/**
 *
 * @author javie
 */
public interface UserRepository extends Repository<User, Integer> {

    boolean containsNombreApellido(String nombre, String apellido);

    boolean containsLoginName(String loginName);

    public Collection<User> findByNombreApellido(String nombre, String apellido) throws Exception;

    public Collection<User> findByLoginName(String loginName) throws Exception;

}
