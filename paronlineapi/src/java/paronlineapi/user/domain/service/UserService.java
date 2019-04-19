/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paronlineapi.user.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import paronlineapi.common.domain.model.entity.Entity;
import paronlineapi.user.domain.model.entity.User;

/**
 *
 * @author javie
 */
public interface UserService {

    public void add(User user) throws Exception;

    public void update(User user) throws Exception;

    public void delete(Integer id) throws Exception;

    public Entity findById(Integer id) throws Exception;

    public Collection<User> findByNombreApellido(String nombre, String apellido) throws Exception;

    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

}
