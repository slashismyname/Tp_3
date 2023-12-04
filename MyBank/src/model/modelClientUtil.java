/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

import vue.accueil_;
import model.modelClient;
import model.modelClient;
import model.Connexion;

/**
 *
 * @author N_OPI
 */
public class modelClientUtil {
    
    Connection con;
    Connexion cn = new Connexion();
    PreparedStatement pst;
    ResultSet rs;
    
    // variable
    
    public int id_mcu;
    public String nom_mcu;
    public String postnom_mcu;
    public double solde_mcu;
    
    
    public boolean Enregistrer(modelClient mc){
        
        String sql = "insert into client(nom,postnom,maila,password,solde)"
                +"value (?,?,?,?,?)";
        
        try{
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
//            pst.setInt(1, mc.getId());
            pst.setString(1, mc.getNom());
            pst.setString(2, mc.getPostnom());
            pst.setString(3, mc.getMaila());
            pst.setString(4,mc.getPassword());
            pst.setDouble(5, mc.getSolde());
            pst.executeUpdate();
            
//            JOptionPane.showMessageDialog(null, "Compte cree");
            return true;
            
            
        }catch(Exception e){
            
            e.printStackTrace();
            return false;
            
        }finally{
            try{
                con.close();
            }catch(Exception e){
                e.printStackTrace(); 
            }
        }
    
    }
    
    public List Liste(){
        List<modelClient> lis = new ArrayList<>();
        
        String sql = "select*from client";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                modelClient mc = new modelClient();
                mc.setId(rs.getInt("id"));
                mc.setNom(rs.getString("nom"));
                mc.setPostnom(rs.getString("postnom"));
                mc.setMaila(rs.getString("maila"));
                mc.setPassword(rs.getString("password"));
                mc.setSolde(rs.getDouble("solde"));
                lis.add(mc);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return lis;
    }
    

    public boolean control(String maila, String password) throws SQLException{
        // Connexion à la base de données

          con = cn.getConnection();

          // Préparation de la requête SQL
          String sql = "SELECT * FROM client WHERE maila = ? AND password = ?";
          pst = con.prepareStatement(sql);

          // Paramètres de la requête
          pst.setString(1, maila);
          pst.setString(2, password);

          // Exécution de la requête
          rs = pst.executeQuery();

          // Retourne true si la requête retourne un résultat
          return rs.next();
    }

    public Map<String, Object> map_(String maila, String table ) throws SQLException {

        // Connexion à la base de données
        con = cn.getConnection();

        // Préparation de la requête SQL
        PreparedStatement pst = con.prepareStatement("SELECT * FROM `" + table + "` WHERE `maila` = ?");

        // Paramètres de la requête
        pst.setString(1, maila);

        // Exécution de la requête
        ResultSet rs = pst.executeQuery();

        // Récupération des attributs
        Map<String, Object> attributs = new HashMap<>();
        if (rs.next()) {
          for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            attributs.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
          }
        }
        
        nom_mcu = (String) attributs.get("nom");
        postnom_mcu = (String) attributs.get("postnom");
        id_mcu = (int) attributs.get("id");
        solde_mcu = (double) attributs.get("solde");

        // Fermeture de la connexion
        con.close();

        return attributs;
    }

    
}
