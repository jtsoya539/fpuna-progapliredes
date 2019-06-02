/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.paronline.paronline;

import py.com.paronline.paronline.service.UserService;

/**
 *
 * @author javie
 */
public class Program {

    public static void main(String[] args) throws Exception {
        UserService us = new UserService();
        System.out.println(us.getUser(5));
    }

}
