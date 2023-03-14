package bibliotecaParcial.model;


import java.util.ArrayList;
import java.util.List;

public class Empleado {

	private String nombre;
	private double salario;
	private String cargo;
	private List<Prestamo> listaPrestamos;

    //CREO LOS CONSTRUCTORES
    

    public Empleado() {

    }


    public Empleado(String nombre, double salario, String cargo, List<Prestamo> listaPrestamos) {
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.listaPrestamos = listaPrestamos;
    }

    public Empleado(String nombre, double salario, String cargo) {
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.listaPrestamos = new ArrayList<Prestamo>();
    }


    //CREO LOS GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        return "Empleado [nombre=" + nombre + ", salario=" + salario + ", cargo=" + cargo + ", listaPrestamos="
                + listaPrestamos + "]";
    }

 
    //CREO EL HASCODE Y EQUALS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
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
        Empleado other = (Empleado) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (cargo == null) {
            if (other.cargo != null)
                return false;
        } else if (!cargo.equals(other.cargo))
            return false;
        return true;
    }

    public boolean verificarPrestamoIsbn(String isbn) {
        for(Prestamo prestamo : listaPrestamos) {
            if(prestamo.darPrestamo(isbn)) {
                return true;
            }
        }
        return false;
    }

}
