/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_arnoldgaldamez;

/**
 *
 * @author USER
 */
public class Variable {
    private String tipo;
    private String nombre;

    public Variable(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }
    
    

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Variable{" + "tipo=" + tipo + ", nombre=" + nombre + '}';
    }
    
    
}
