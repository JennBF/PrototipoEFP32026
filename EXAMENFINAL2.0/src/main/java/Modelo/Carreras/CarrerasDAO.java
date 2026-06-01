/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Carreras;

/**
 *
 * @author JENNIFER BARRIOS 9959-24-10016
 */
import Controlador.Carreras.clsCarreras;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrerasDAO {
    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera, FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera, codigo_facultad, estatus_carrera) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad=?, estatus_carrera=?,  WHERE codigo_carrera=?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera,  FROM carreras WHERE codigo_carrera=?";

    public List<clsCarreras> consultaCarreras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCarreras> carreras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                clsCarreras carrera = new clsCarreras();
                carrera.setcodigo_carrera(rs.getString("codigo_carrera"));
                carrera.setnombre_carrera(rs.getString("nombre_carrera"));
                carrera.setcodigo_facultad(rs.getString("codigo_facultad"));
                carrera.setestatus_carrera(rs.getString("estatus_carrera"));
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return carreras;
    }
    
    public clsCarreras consultaCarreraPorId(clsCarreras carrera) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Conexion.getConnection();
        // SQL_QUERY es la que tiene el WHERE codigo_carrera = ?
        stmt = conn.prepareStatement(SQL_QUERY); 
        stmt.setString(1, carrera.getcodigo_carrera()); // Aquí pasas el ID que quieres buscar
        rs = stmt.executeQuery();
        
        if (rs.next()) { // Solo usamos IF porque esperamos un solo resultado
            carrera.setnombre_carrera(rs.getString("nombre_carrera"));
            carrera.setcodigo_facultad(rs.getString("codigo_facultad"));
            carrera.setestatus_carrera(rs.getString("estatus_carrera"));
            
        }
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return carrera; 
}

    public int ingresarCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getnombre_carrera());
            stmt.setString(2, carrera.getcodigo_facultad());
            stmt.setString(3, carrera.getestatus_carrera());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizarCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carrera.getnombre_carrera());
            stmt.setString(2, carrera.getcodigo_facultad());
            stmt.setString(3, carrera.getestatus_carrera());
            stmt.setString(7, carrera.getcodigo_carrera());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int borrarCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, carrera.getcodigo_carrera());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}

