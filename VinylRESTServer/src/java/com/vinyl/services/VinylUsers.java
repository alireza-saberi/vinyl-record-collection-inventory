/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinyl.services;

import com.vinyl.DAO.UserDAO;
import com.vinyl.model.Users;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author alans
 */
@Path("user")
public class VinylUsers {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Books
     */
    public VinylUsers() {
    }

    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void addUser(Users user) {
        UserDAO db = new UserDAO();
        db.addUser(user);
    }

    @DELETE
    @Path("/deluser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void deleteUser(Users user) {
        UserDAO db = new UserDAO();
        db.deleteUser(user);
    }

    @PUT
    @Path("/updateuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void updateUser(Users user) {
        UserDAO db = new UserDAO();
        db.deleteUser(user);
    }

    @POST
    @Path("/isuservalid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public void isUserValid(Users user) {
        UserDAO db = new UserDAO();
        db.isUserValid(user);
    }

    @POST
    @Path("/readuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public Users readUser(Users user) {
        UserDAO db = new UserDAO();
        return db.readUser(user);
    }

}
