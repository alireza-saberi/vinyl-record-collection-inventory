/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinyl.services;

import com.vinyl.DAO.UserDAO;
import com.vinyl.model.Users;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author alans
 */
public class VinylUsersTest {
    @Mock
    private UserDAO daoMock;

    @InjectMocks
    private VinylUsers service;
       
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    


    /**
     * Test of addUser method, of class VinylUsers.
     */
    @Test
    public void testAddUser() {
        System.out.println("Runing test for addUser");
        when(daoMock.addUser(any(Users.class))).thenReturn(1);
        Users user = new Users();
        assertEquals(service.addUser(user), 1);
    }

    /**
     * Test of deleteUser method, of class VinylUsers.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("Runing test for deleteUser");
        when(daoMock.deleteUser(any(Users.class))).thenReturn(1);
        Users user = new Users();
        assertEquals(service.deleteUser(user), 1);
    }

    /**
     * Test of updateUser method, of class VinylUsers.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("Runing test for updateUser");
        when(daoMock.updateUser(any(Users.class))).thenReturn(1);
        Users user = new Users();
        assertEquals(service.updateUser(user), 1);
    }

    /**
     * Test of isUserValid method, of class VinylUsers.
     */
    @Test
    public void testIsUserValid() {
        System.out.println("Runing test for isUserValid");
        when(daoMock.isUserValid(any(Users.class))).thenReturn(true);
        Users user = new Users();
        assertEquals(service.isUserValid(user), true);
    }

    /**
     * Test of readUser method, of class VinylUsers.
     */
    @Test
    public void testReadUser() {
        System.out.println("Runing test for readUser");
        when(daoMock.readUser(any(Users.class))).thenReturn(new Users("FirstName", "LastName", "user", "pass"));
        Users user = new Users("FirstName", "LastName", "user", "pass");
        assertEquals(service.readUser(user).getFirst_name(), user.getFirst_name());
        assertEquals(service.readUser(user).getLast_name(), user.getLast_name());
        assertEquals(service.readUser(user).getUsername(), user.getUsername());
        assertEquals(service.readUser(user).getUser_password(), user.getUser_password());       
    }
    
}
