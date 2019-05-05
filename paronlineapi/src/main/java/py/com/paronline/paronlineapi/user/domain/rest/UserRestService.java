/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronlineapi.user.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import py.com.paronline.paronlineapi.user.domain.model.entity.User;
import py.com.paronline.paronlineapi.user.domain.repository.JdbcUserRepository;
import py.com.paronline.paronlineapi.user.domain.service.UserServiceImpl;

/**
 *
 * @author javie
 */
@Path("userapi")
public class UserRestService {

    private final UserServiceImpl userService = new UserServiceImpl(new JdbcUserRepository());

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsers() {
        ArrayList<User> users = (ArrayList) userService.getAll();
        return users;
    }

    @GET
    @Path("users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Integer id) {
        User entity = null;
        try {
            entity = (User) userService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(UserRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("users")
    @Consumes("application/json")
    @Produces("application/json")
    public User addUser(User entity) {
        try {
            userService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(UserRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @PUT
    @Path("users")
    @Consumes("application/json")
    public void updateUser(User entity) {
        try {
            userService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(UserRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("users/{id}")
    public void removeUser(@PathParam("id") Integer id) {
        try {
            userService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(UserRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
