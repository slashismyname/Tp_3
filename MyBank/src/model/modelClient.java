/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author N_OPI
 */
public class modelClient {
    
    private int id;
    private String nom;
    private String postnom;
    private String maila;
    private String password;
    private double solde;

    public modelClient(int id, String nom, String postnom, String maila, String password, double solde) {
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.maila = maila;
        this.password = password;
        this.solde = solde;
    }


    public modelClient(){
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getMaila() {
        return maila;
    }

    public void setMaila(String maila) {
        this.maila = maila;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
    
}
