/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline.client;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import py.com.paronline.paronline.model.User;

/**
 *
 * @author javie
 */
@Path("userapi")
public interface UserClient {

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsers();

    @GET
    @Path("users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Integer id);

    @POST
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user);

    @PUT
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user);

    @DELETE
    @Path("users/{id}")
    public void removeUser(@PathParam("id") Integer id);

}
