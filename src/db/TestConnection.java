/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.Connection;
/**
 *
 * @author w7
 */
public class TestConnection {
    public static void main(String args[])
    {
         DbContext db = new DbContext();
         Connection con =db.getConnection();         
         if(con!=null)
         {
             System.out.println("Ket noi CSDL thanh cong");
         }else
         {
             System.out.println("Ket noi du lieu that bai");
         }         
    }
}
