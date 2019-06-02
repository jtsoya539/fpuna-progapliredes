/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline.service;

import java.util.ArrayList;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import py.com.paronline.paronline.client.UserClient;
import py.com.paronline.paronline.model.User;

/**
 *
 * @author javie
 */
public class UserService {

    private static ResteasyClient rClient;
    private static ResteasyWebTarget rWebTarget;
    private static UserClient userClient;

    public UserService() {
        rClient = new ResteasyClientBuilder().build();
        rWebTarget = rClient.target("http://localhost:8080/paronlineapi/rest");
        userClient = rWebTarget.proxy(UserClient.class);
    }

    public ArrayList<User> getUsers() {
        return userClient.getUsers();
    }

    public User getUser(Integer id) {
        return userClient.getUser(id);
    }

    public void addUser(User user) {
        user = userClient.addUser(user);
    }
    
    public void updateUser(User user) {
        userClient.updateUser(user);
    }
    
    public void removeUser(Integer id) {
        userClient.removeUser(id);
    }

}
