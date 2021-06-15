/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author w7
 */
public class DbContext {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;           
            con = DriverManager.getConnection(url, userID, password);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        return con;
    }    
    /*Insert your other code right safter this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "PC213\\SQLSERVER"; //127.0.0.1
    private final String dbName = "QLDaoTao";
    //private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "12345";
   
}
