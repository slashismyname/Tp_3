/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author N_OPI
 */
public class Connexion {
    
    Connection con;
    
    public Connection getConnection(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mybank",  "root","");
            return con;
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        
        
        return null;
    }
    
    
    
}
