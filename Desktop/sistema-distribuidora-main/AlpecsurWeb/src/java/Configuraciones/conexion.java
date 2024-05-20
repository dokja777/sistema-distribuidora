/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author piero
 */
public class conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/alpecsur_bd?useUnicode=true&characterEncoding=UTF-8";
    String user = "root";
    String pass = "";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Conexión fallida..." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Falta Driver " + ex.getMessage());
        }
        return con;
    }

    public void cerrarConexion(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("ERROR al cerrar la conexión: " + e.getMessage());
        }
    }
    
        public static void main(String[] args) {
        conexion con = new conexion();
        Connection connection = con.Conexion();
        if (connection != null) {
            System.out.println("Conexión exitosa");
            con.cerrarConexion(connection);
        } else {
            System.out.println("Conexión fallida");
        }
    }
}

