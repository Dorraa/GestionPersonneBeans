/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Beans;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author dorra
 */
public class Gestion implements Serializable{
   private boolean con=true;
   private String user=null;
   private String pass=null;
   private String nom=null;
   private String age=null;
   private String id=null;
   Connection connexion;
    /**
     * @return the con
     */
    public boolean isCon() {
        System.out.println("------------------------------------------------------");
        System.out.println("init method has been called and servlet is initialized");
        System.out.println("------------------------------------------------------");
        String url="jdbc:mysql://127.0.0.1:3306/bd";
        String name="root";
        String pwd="dorra";
        String driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver).newInstance();
            connexion=DriverManager.getConnection(url,name , pwd);  
        }
        catch(Exception e){
            con=false;
           System.out.println("error while loading...");
         System.out.println(e);
        }
        
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(boolean con) {
        this.con = con;
    }

    /**
     * @return the user
     */
    public String getUser(String name) {
       try{
        String q="select * from user where username='"+name+"'";
           Statement commande=connexion.createStatement();
           ResultSet rs=commande.executeQuery(q);
           
           
           while(rs.next()){
               user=rs.getString(2);
               
               
           }
           rs.close();
           commande.close();
    }
       catch(SQLException ex){
          ex.printStackTrace();
       }
       catch(Exception e){
           e.printStackTrace();
       }
            return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass(String pwd) {
      try{
           
           String q="select * from user where username='"+user+"'";
           Statement commande=connexion.createStatement();
           ResultSet rs=commande.executeQuery(q);
           while(rs.next()){
              
               pass=rs.getString(3);
               
           }
           rs.close();
           commande.close();
       }
           
       catch(SQLException ex){
          ex.printStackTrace();
       }
       catch(Exception e){
           e.printStackTrace();
       }
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the nom
     */
    public String getNom(String idp) {
         try {
            /* TODO output your page here. You may use following sample code. */
            String q = "select nom from personnes where id=" + idp;
            Statement commande = connexion.createStatement();
            ResultSet rs = commande.executeQuery(q);

            while (rs.next()) {

                nom = rs.getString(1);
                
            }
        } catch (SQLException es) {
            System.out.println(es.toString());
        }
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the age
     */
    public String getAge(String idp) {
         try {
            /* TODO output your page here. You may use following sample code. */
            String q = "select age from personnes where id=" + idp;
            Statement commande = connexion.createStatement();
            ResultSet rs = commande.executeQuery(q);

            while (rs.next()) {

                age = rs.getString(1);
                
            }
        } catch (SQLException es) {
            System.out.println(es.toString());
        }
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the id
     */
    public String getId(String name,String ag) {
        try {
            /* TODO output your page here. You may use following sample code. */
            String q = "select id from personnes where nom='" + name + "' and age=" + ag;
            Statement commande = connexion.createStatement();
            ResultSet rs = commande.executeQuery(q);

            while (rs.next()) {

                id = rs.getString(1);
            }
            
        } catch (SQLException es) {
            System.out.println(es.toString());
        }
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
   
}
