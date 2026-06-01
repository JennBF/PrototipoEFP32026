/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Carreras;

/**
 *
 * @author JENNIFER BARRIOS 
 */
// JENNIFER BARRIOS, ENCARGADA DE PROVEEDORES.

public class clsCarreras {
    private int codigo_carrera;
    private String nombre_carrera;
    private int codigo_facultad;
    private String estatus_carrera;
   
    

    public clsCarreras() {
    }

    public clsCarreras(int codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    // Getters y Setters
    public int getcodigo_carrera() { return codigo_carrera; }
    public void setcodigo_carrera(int codigo_carrera) { this.codigo_carrera = codigo_carrera; }

    public String getnombre_carrera() { return nombre_carrera; }
    public void setnombre_carrera(String nombre_carrera) { this.nombre_carrera = nombre_carrera; }

    public int getCodigo_facultad() {
        return codigo_facultad;
    }

    public void setCodigo_facultad(int codigo_facultad) {
        this.codigo_facultad = codigo_facultad;
    }

    

    public String getestatus_carrera() { return estatus_carrera; }
    public void setestatus_carrera(String estatus_carrera) { this.estatus_carrera = estatus_carrera; }

    @Override
    public String toString() {
        return "clsCarreras{" + "codigo_carrera=" + codigo_carrera + ", nombre_carrera=" + nombre_carrera + ", codigo_facultad=" + codigo_facultad + ", estatus_carrera=" + estatus_carrera + '}';
    }

 

}
