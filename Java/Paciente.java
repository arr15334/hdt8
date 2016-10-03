/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo Arriaza;
 */
public class Paciente implements Comparable<Paciente>{
    private String nombre, enfermedad, prioridad;

    public Paciente(String nombre, String enfermedad, String prioridad) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.prioridad=prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getPriority() {
        return prioridad;
    }

    public void setPriority(String prioridad) {
        this.prioridad=prioridad;
    }

    @Override
    public int compareTo(Paciente otro) {
        return prioridad.compareTo(otro.getPriority());
    }

    public String toString(){
        return getNombre()+", "+getEnfermedad()+", "+getPriority();
    }
    
    
}

