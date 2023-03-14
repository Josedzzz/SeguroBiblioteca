package bibliotecaParcial.model;


import java.util.List;

public class Prestamo {

    private String fecha;
	private double total;
	private int tiempoEntrega;
	private String codigo;
    private Empleado empleadoPrestamo;
	private List<DetallePrestamo> listaDetallePrestamos;

    //CREO LOS CONSTRUCTORES
    

    public Prestamo() {

    }


    public Prestamo(String fecha, double total, int tiempoEntrega, String codigo,
            List<DetallePrestamo> listaDetallePrestamos) {
        this.fecha = fecha;
        this.total = total;
        this.tiempoEntrega = tiempoEntrega;
        this.codigo = codigo;
        this.listaDetallePrestamos = listaDetallePrestamos;
    }

    


    public Prestamo(String fecha, double total, int tiempoEntrega, String codigo, Empleado empleadoPrestamo,
            List<DetallePrestamo> listaDetallePrestamos) {
        this.fecha = fecha;
        this.total = total;
        this.tiempoEntrega = tiempoEntrega;
        this.codigo = codigo;
        this.empleadoPrestamo = empleadoPrestamo;
        this.listaDetallePrestamos = listaDetallePrestamos;
    }


    //CREO LOS GETTERS Y SETTERS
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(List<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }


    //CREO EL TO STRING
    @Override
    public String toString() {
        return "Prestamo [fecha=" + fecha + ", total=" + total + ", tiempoEntrega=" + tiempoEntrega + ", codigo="
                + codigo + ", listaDetallePrestamos=" + listaDetallePrestamos + "]";
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
        Prestamo other = (Prestamo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    public boolean darPrestamo(String isbn) {
        for(DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.getLibro().getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarEmpleadoUnidad() {
        boolean cumple = false;

        boolean empleadoCumple = false;
        boolean unidadCumple = false;

        empleadoCumple = verificarEmpleado();
        unidadCumple = verificarUnidad();

        if(unidadCumple == true && empleadoCumple == true) {
            cumple = true;
        }
        return cumple;

    }

    public boolean verificarEmpleado() {
        if(empleadoPrestamo.getSalario() >= 2) {
            return true;
        }
        return false;
    }

    public boolean verificarUnidad() {
        for(DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            if(detallePrestamo.darUnidad()) {
                return true;
            }
        }
        return false;
    }




    
    

}
