package bibliotecaParcial.model;

public class DetallePrestamo {

	private String codigo;
	private double subTotal;
	private int cantidad;
	private Libro libro;

    //CREO LOS CONSTRUCTORES
    public DetallePrestamo(String codigo, double subTotal, int cantidad, Libro libro) {
        this.codigo = codigo;
        this.subTotal = subTotal;
        this.cantidad = cantidad;
        this.libro = libro;
    }

    public DetallePrestamo() {

    }


    //CREO LOS GETTERS Y SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    //CREO EL TO STRING
    @Override
    public String toString() {
        return "DetallePrestamo [codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + ", libro="
                + libro + "]";
    }


    //CREO EL HASCODE Y EQUALS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        DetallePrestamo other = (DetallePrestamo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    public boolean darUnidad() {
        if(cantidad >= 5 && cantidad <= 15) {
            return true;
        }
        return false;
    }

    
    
    

}
