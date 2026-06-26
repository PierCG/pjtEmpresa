/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pjtempresa;

import java. sql.Connection;
import java.sql.DriverManager;
import javax. swing. JOptionPane;

/**
 *
 * @author ASUS
 */
public class CConexion {
    
    Connection conectar = null; 
    
    String usuario = "Usuario01"; 
    String contrasenia = "01Usuario"; 
    String bd = "BDEMPRESA"; 
    String ip ="localhost"; 
    String puerto = "1433"; 
    
    public Connection establecerConexion(){ 
        try 
        { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            String cadena="jdbc:sqlserver://" + ip + ":" + puerto + ";" + 
            "databaseName=" + bd + "; " + "TrustServerCertificate = True;"; 
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia); 
        } 
        catch(Exception e) 
        { 
            JOptionPane.showMessageDialog(null, "Error"); 
        }   
        return conectar;
    } 
}
