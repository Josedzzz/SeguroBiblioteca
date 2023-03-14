package bibliotecaParcial.test;



import javax.swing.JOptionPane;

import bibliotecaParcial.model.Biblioteca;
import bibliotecaParcial.model.DetallePrestamo;
import bibliotecaParcial.model.Empleado;
import bibliotecaParcial.model.Libro;
import bibliotecaParcial.model.Prestamo;

public class test {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("UQ", "Armenia", "123456789");
        String estado = "";

        //PARA PROBAR EL PRIMER PUNTO DEL TALLER
        /*Libro libro = new Libro("12345", "El gato con botas", "Shrek");
        DetallePrestamo detallePrestamo = new DetallePrestamo("54321", 10000.0, 5, libro);
        biblioteca.getListaDetallesPrestamos().add(detallePrestamo);
        Prestamo prestamo = new Prestamo("Enero", 10000.0, 4, "123456789", biblioteca.getListaDetallesPrestamos());
        biblioteca.getListaPrestamos().add(prestamo);
        Empleado empleado = new Empleado("Samuel", 1000000.0, "director", biblioteca.getListaPrestamos());
        Empleado empleado1 = new Empleado("Manuel", 10.0, "Jr");
        biblioteca.getListaEmpleados().add(empleado1);
        biblioteca.getListaEmpleados().add(empleado);*/
        

        /*try {
            estado = biblioteca.crearEstudiante("Jose", "Amaya", 18, "Sistemas", "Soltero", "123");
            JOptionPane.showMessageDialog(null, estado);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            Empleado empleadoPrestamo = biblioteca.obtenerInfoEmpleadoPrestamo("12345");
            System.out.println(empleadoPrestamo.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


       //PARA PROBAR EL SEGUNDO PUNTO DEL TALLER
       Libro libro = new Libro("12345", "El gato con botas", "Shrek");
       DetallePrestamo detallePrestamo1 = new DetallePrestamo("54321", 10000.0, 5, libro);
       biblioteca.getListaDetallesPrestamos().add(detallePrestamo1);
       Empleado empleado2 = new Empleado("Samuel", 1000000.0, "director", biblioteca.getListaPrestamos());
       Prestamo prestamo1 = new Prestamo("Enero", 10000.0, 4, "123456789",empleado2, biblioteca.getListaDetallesPrestamos());
       biblioteca.getListaPrestamos().add(prestamo1);
       biblioteca.getListaEmpleados().add(empleado2);

        try {
            Prestamo prestamoPrueba = biblioteca.obtenerPrestamoUnidadEmpleado();
            System.out.println(prestamoPrueba);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
