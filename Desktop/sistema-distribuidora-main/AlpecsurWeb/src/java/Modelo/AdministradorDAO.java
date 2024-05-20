/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Configuraciones.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List<Administrador> listar() {
        String sql = "SELECT * FROM administrador";
        List<Administrador> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Administrador adm = new Administrador();
                adm.setIdProveedor(rs.getInt("idProveedor"));
                adm.setIdUsuario(rs.getInt("idUsuario"));
                adm.setNombre(rs.getString("nombre"));
                adm.setTipoDocumento(rs.getString("tipoDocumento"));
                adm.setNumDocumento(rs.getString("numDocumento"));
                adm.setDireccion(rs.getString("direccion"));
                adm.setTelefono(rs.getString("telefono"));
                adm.setEmail(rs.getString("email"));
                lista.add(adm);
            }
        } catch (Exception e) {
            System.out.println("ERROR en Listar AdministradorDAO: " + e.getMessage());
        }
        return lista;
    }

    public Administrador listarPorId(int id) {
        Administrador adm = new Administrador();
        String sql = "SELECT * FROM administrador WHERE idProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                adm.setIdProveedor(rs.getInt("idProveedor"));
                adm.setIdUsuario(rs.getInt("idUsuario"));
                adm.setNombre(rs.getString("nombre"));
                adm.setTipoDocumento(rs.getString("tipoDocumento"));
                adm.setNumDocumento(rs.getString("numDocumento"));
                adm.setDireccion(rs.getString("direccion"));
                adm.setTelefono(rs.getString("telefono"));
                adm.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("ERROR en ListarPorId AdministradorDAO: " + e.getMessage());
        }
        return adm;
    }

    public int agregar(Administrador adm) {
        String sql = "INSERT INTO administrador (idUsuario, nombre, tipoDocumento, numDocumento, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, adm.getIdUsuario());
            ps.setString(2, adm.getNombre());
            ps.setString(3, adm.getTipoDocumento());
            ps.setString(4, adm.getNumDocumento());
            ps.setString(5, adm.getDireccion());
            ps.setString(6, adm.getTelefono());
            ps.setString(7, adm.getEmail());
            r = ps.executeUpdate();
            System.out.println("Administrador agregado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR en Agregar AdministradorDAO: " + e.getMessage());
        }
        return r;
    }

    public int actualizar(Administrador adm) {
        String sql = "UPDATE administrador SET idUsuario=?, nombre=?, tipoDocumento=?, numDocumento=?, direccion=?, telefono=?, email=? WHERE idProveedor=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, adm.getIdUsuario());
            ps.setString(2, adm.getNombre());
            ps.setString(3, adm.getTipoDocumento());
            ps.setString(4, adm.getNumDocumento());
            ps.setString(5, adm.getDireccion());
            ps.setString(6, adm.getTelefono());
            ps.setString(7, adm.getEmail());
            ps.setInt(8, adm.getIdProveedor());
            r = ps.executeUpdate();
            System.out.println("Administrador actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR en Actualizar AdministradorDAO: " + e.getMessage());
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM administrador WHERE idProveedor=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Administrador eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR en Eliminar AdministradorDAO: " + e.getMessage());
        }
    }
}
