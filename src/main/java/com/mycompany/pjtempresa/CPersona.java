/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pjtempresa;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.CallableStatement;

/**
 *
 * @author ASUS
 */
public class CPersona {
    
    public void mostrarPersona(JTable paramTablaPersona) {
        CConexion objetoConexion = new CConexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT * FROM TBLPERSONA;";
        modelo.addColumn("CODIPERSO");
        modelo.addColumn("NOMBREPERSO");
        modelo.addColumn("GENERO");
        paramTablaPersona.setModel(modelo);
        String[] datos = new String[3];
        Statement st;
        try {
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
            paramTablaPersona.setModel(modelo);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void agregarPersona(JTextField paramcodiPerso, JTextField paramnombrePerso, JTextField paramgenero) {
        CConexion objetoConexion = new CConexion();
        String sql = "INSERT INTO TBLPERSONA (CODIPERSO, NOMBREPERSO, GENERO) VALUES (?,?,?);";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(sql);
            cs.setString(1, paramcodiPerso.getText());
            cs.setString(2, paramnombrePerso.getText());
            cs.setString(3, paramgenero.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Agregado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }

    public void actualizarPersona(JTextField paramcodiPerso, JTextField paramnombrePerso, JTextField paramgenero) {
        CConexion objetoConexion = new CConexion();
        String sql = "UPDATE TBLPERSONA SET NOMBREPERSO = ?, GENERO = ? WHERE CODIPERSO = ?;";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(sql);
            cs.setString(1, paramnombrePerso.getText());
            cs.setString(2, paramgenero.getText());
            cs.setString(3, paramcodiPerso.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }

    public void eliminarPersona(JTextField paramcodiPerso) {
        CConexion objetoConexion = new CConexion();
        String sql = "DELETE FROM TBLPERSONA WHERE CODIPERSO = ?;";
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(sql);
            cs.setString(1, paramcodiPerso.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }
}