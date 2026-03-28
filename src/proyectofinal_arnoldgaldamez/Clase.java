/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_arnoldgaldamez;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
public class Clase {
    private String nombre;
    private ArrayList<String> atributos = new ArrayList<>();
    private ArrayList<String> metodos = new ArrayList<>();
    private String herencia;

    public Clase(String nombre) {
        this.nombre = nombre;
        this.herencia = "";
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getAtributos() {
        return atributos;
    }

    public ArrayList<String> getMetodos() {
        return metodos;
    }

    public String getHerencia() {
        return herencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHerencia(String herencia) {
        this.herencia = herencia;
    }

    @Override
    public String toString() {
        String texto = nombre;

        if (!herencia.isEmpty()) {
            texto += " extends " + herencia;
        }

        texto += "\nAtributos:\n";
        for (String a : atributos) {
            texto += a + "\n";
        }

        texto += "Metodos:\n";
        for (String m : metodos) {
            texto += m + "\n";
        }

        return texto;
    }
}
