/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.user.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import py.com.paronline.paronlineapi.common.domain.model.entity.Entity;
import py.com.paronline.paronlineapi.common.domain.service.BaseService;
import py.com.paronline.paronlineapi.user.domain.model.entity.User;
import py.com.paronline.paronlineapi.user.domain.repository.UserRepository;

/**
 *
 * @author javie
 */
public class UserServiceImpl extends BaseService<User, Integer> implements UserService {

    private UserRepository userRepository;

    /**
     *
     * @param userRepository
     */
    //@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) throws Exception {
        if (userRepository.containsNombreApellido(user.getNombre(), user.getApellido())) {
            throw new Exception(String.format("Ya existe un usuario con el nombre %s y el apellido %s", user.getNombre(), user.getApellido()));
        }

        if (userRepository.containsLoginName(user.getLoginName())) {
            throw new Exception(String.format("Ya existe un usuario con el login name %s", user.getLoginName()));
        }

        if (user.getNombre() == null || "".equals(user.getNombre())) {
            throw new Exception("El nombre del usuario no puede ser nulo o cadena vacia.");
        }

        if (user.getApellido() == null || "".equals(user.getApellido())) {
            throw new Exception("El apellido del usuario no puede ser nulo o cadena vacia.");
        }

        super.add(user);
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    @Override
    public Collection<User> findByNombreApellido(String nombre, String apellido) throws Exception {
        return userRepository.findByNombreApellido(nombre, apellido);
    }

    /**
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void update(User user) throws Exception {
        userRepository.update(user);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        userRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User findById(Integer id) throws Exception {
        return userRepository.get(id);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
