/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinyl.services;

import com.vinyl.DAO.AlbumDAO;
import com.vinyl.DAO.UserDAO;
import com.vinyl.model.Album;
import com.vinyl.model.UserAlbum;
import com.vinyl.model.Users;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
public class VinylAlbumsTest {
    @Mock
    private UserDAO userDaoMock;
    
    @Mock
    private AlbumDAO albumDaoMock;

    @InjectMocks
    private VinylAlbums service;
       
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    /**
     * Test of addAlbum method, of class VinylAlbums.
     */
    @Test
    public void testAddAlbum() {
        System.out.println("Runing test for addAlbum");
        when(albumDaoMock.addAlbum(any(Users.class), any(Album.class))).thenReturn(1);
        UserAlbum userAlbum = new UserAlbum();
        assertEquals(service.addAlbum(userAlbum),1);
    }

    /**
     * Test of readAlbums method, of class VinylAlbums.
     */
    @Test
    public void testReadAlbums() {
        System.out.println("Runing test for readAlbums");
        when(albumDaoMock.readAlbums(any(Users.class))).thenReturn(new ArrayList<Album>());        
        Users user = new Users();
        assertEquals(service.readAlbums(user),is(notNullValue()));

    }

    /**
     * Test of updateAlbum method, of class VinylAlbums.
     */
    @Test
    public void testUpdateAlbum() {
        System.out.println("Runing test for updateAlbum");
        when(albumDaoMock.updateAlbum(any(Users.class), any(Album.class))).thenReturn(1);
        UserAlbum userAlbum = new UserAlbum();
        assertEquals(service.updateAlbum(userAlbum),1);

    }

    /**
     * Test of deleteAlbum method, of class VinylAlbums.
     */
    @Test
    public void testDeleteAlbum() {
        System.out.println("Runing test for deleteAlbum");
        when(albumDaoMock.deleteAlbum(any(Users.class), any(Album.class))).thenReturn(1);
        UserAlbum userAlbum = new UserAlbum();
        assertEquals(service.deleteAlbum(userAlbum),1);
    }

    /**
     * Test of deleteAllAlbum method, of class VinylAlbums.
     */
    @Test
    public void testDeleteAllAlbum() {
        System.out.println("Runing test for deleteAllAlbum");
        when(albumDaoMock.deleteAllAlbum(any(Users.class))).thenReturn(1);
        Users user = new Users();
        assertEquals(service.deleteAllAlbum(user),1);        
    }
    
}
