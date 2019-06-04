/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinyl.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author alans
 */
public class DBConnectorTest {

    @InjectMocks
    private DBConnector dbConnection;
    @Mock
    private Connection mockConnection;
    @Mock
    private Statement mockStatement;

    public DBConnectorTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test of getConnection method, of class DBConnector.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("Testing getConnection");
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        int value = dbConnection.executeQuery("");
        Assert.assertEquals(value, 1);
        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));

    }
}
