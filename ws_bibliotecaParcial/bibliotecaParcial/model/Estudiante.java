package bibliotecaParcial.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private String programa;
    private String estado;
    private String identificacion;
    private List<Prestamo> listaPrestamos;

    
    //CREO LOS CONSTRUCTORES
    public Estudiante(String nombre, String apellido, int edad, String programa, String estado, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.programa = programa;
        this.estado = estado;
        this.identificacion = identificacion;
        this.listaPrestamos = new ArrayList<Prestamo>();
    }


    //CREO LOS GETTER Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }


    //CREO EL TO STRING
    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", programa=" + programa
                + ", estado=" + estado + ", identificacion=" + identificacion + ", listaPrestamos=" + listaPrestamos
                + "]";
    }


    //CREO EL HASHCODE Y EQUALS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (identificacion == null) {
            if (other.identificacion != null)
                return false;
        } else if (!identificacion.equals(other.identificacion))
            return false;
        return true;
    }

    

    
    
    

}
