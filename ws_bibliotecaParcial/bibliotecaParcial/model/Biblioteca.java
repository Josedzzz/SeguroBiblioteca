package bibliotecaParcial.model;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private String telefono;
    private List<Estudiante> listaEstudiantes;
    private List<Prestamo> listaPrestamos;
    private List<Empleado> listaEmpleados;
    private List<Libro> listaLibros;
    private List<DetallePrestamo> listaDetallesPrestamos;

    //CREO LOS CONSTRUCTORES
    public Biblioteca(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaEmpleados = new ArrayList<Empleado>();
        this.listaEstudiantes = new ArrayList<Estudiante>();
        this.listaLibros = new ArrayList<Libro>();
        this.listaPrestamos = new ArrayList<Prestamo>();
        this.listaDetallesPrestamos = new ArrayList<DetallePrestamo>();
    }

    public Biblioteca() {

    }


    //CREO LOS GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public List<DetallePrestamo> getListaDetallesPrestamos() {
        return listaDetallesPrestamos;
    }

    public void setListaDetallesPrestamos(List<DetallePrestamo> listaDetallesPrestamos) {
        this.listaDetallesPrestamos = listaDetallesPrestamos;
    }

    //CREO EL TO STRING
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
                + ", listaEstudiantes=" + listaEstudiantes + ", listaPrestamos=" + listaPrestamos + ", listaEmpleados="
                + listaEmpleados + ", listaLibros=" + listaLibros + "]";
    }

    //CREO EL HASHCODE Y EQUALS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Biblioteca other = (Biblioteca) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    /**
     * 
     * @param identificacion
     * @return Me retorna el estudiante al que le corresponde la identificacion. Null si no existe
     */
    public Estudiante obtenerEstudiante(String identificacion) {
        Estudiante estudianteEncontrado = null;
        for(Estudiante estudiante : listaEstudiantes) {
            if(estudiante.getIdentificacion().equals(identificacion)) {
                estudianteEncontrado = estudiante;
            }
        }
        return estudianteEncontrado;
    }


    /**
     * 
     * @param nombre
     * @param apellido
     * @param edad
     * @param programa
     * @param estado
     * @param identificacion
     * @return Mensaje positivo si el estudiante pudo ser creado
     * @throws Exception
     */
    public String crearEstudiante(String nombre, String apellido, int edad, String programa, String estado, 
    String identificacion) throws Exception {
        String mensaje = "El estudiante ha sido creado";
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado != null) {
            throw new Exception("El estudiante ya existe");
        } else {
            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, programa, estado, identificacion);
            listaEstudiantes.add(nuevoEstudiante);
        }
        return mensaje;
    }

    /**
     * 
     * @param identificacion
     * @return Un mensaje positivo si el estudiante se pudo eliminar
     * @throws Exception
     */
    public String eliminarEstudiante(String identificacion) throws Exception {
        String mensaje = "El estudiante ha sido eliminado";
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null) {
            throw new Exception("El estudiante no está registrado");
        }
        listaEstudiantes.remove(estudianteEncontrado);
        return mensaje;
    }

    /**
     * 
     * @param nombre
     * @param apellido
     * @param edad
     * @param programa
     * @param estado
     * @param identificacion
     * @return Mensaje positivo si se logró actualizar los datos del estudiante
     * @throws Exception
     */
    public String actualizarEstudiante(String nombre, String apellido, int edad, String programa, String estado, 
    String identificacion) throws Exception {
        String mensaje = "Los datos del estuciante han sido actualizados";
        Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
        if(estudianteEncontrado == null) {
            throw new Exception("El estudiante no está registrado");
        }
        estudianteEncontrado.setNombre(nombre);
        estudianteEncontrado.setApellido(apellido);
        estudianteEncontrado.setEdad(edad);
        estudianteEncontrado.setPrograma(programa);
        estudianteEncontrado.setEstado(estado);

        return mensaje;
    }

    /**
     * 
     * @param nombre
     * @return El empleado al que le corresponde el nombre. Null si no lo encuentra
     */
    public Empleado obtenerEmpleado(String nombre) {
        Empleado empleadoEncontrado = null;
        for(Empleado empleado : listaEmpleados) {
            if(empleado.getNombre().equals(nombre)) {
                empleadoEncontrado = empleado;
            }
        }
        return empleadoEncontrado;
    }

    /**
     * 
     * @param nombre
     * @param salario
     * @param cargo
     * @return Un mensaje positivo si el empleado pudo ser creado
     * @throws Exception
     */
    /*public String crearEmpleado(String nombre, double salario, String cargo) throws Exception {
        String mensaje = "El empleado ha sido creado";
        Empleado empleadoEncontrado = obtenerEmpleado(nombre);
        if(empleadoEncontrado != null) {
            throw new Exception("El empleado ya existe");
        } else {
            Empleado nuevoEmpleado = new Empleado(nombre, salario, cargo);
            listaEmpleados.add(nuevoEmpleado);
        }
        return mensaje;
    }*/

    /**
     * 
     * @param nombre
     * @return Un mensaje positivo si el empleado pudo ser eleminado
     * @throws Exception
     */
    public String eliminarEmpleado(String nombre) throws Exception {
        String mensaje = "El empleado ha sido eliminado";
        Empleado empleadoEncontrado = obtenerEmpleado(nombre);
        if(empleadoEncontrado == null) {
            throw new Exception("El empleado no está registrado");
        }
        listaEmpleados.remove(empleadoEncontrado);
        return mensaje;
    }

    /**
     * 
     * @param nombre
     * @param salario
     * @param cargo
     * @return Un mensaje positivo si se pudo actualizar los datos del empleado
     * @throws Exception
     */
    public String actualizarEmpleado(String nombre, double salario, String cargo) throws Exception {
        String mensaje = "Los datos del empleado han sido actualizados";
        Empleado empleadoEncontrado = obtenerEmpleado(nombre);
        if(empleadoEncontrado == null) {
            throw new Exception("El empleado no está registrado");
        }
        empleadoEncontrado.setSalario(salario);
        empleadoEncontrado.setCargo(cargo);
        return mensaje;
    }

    /**
     * 
     * @param isbn
     * @return Libro encontrado por el isbn
     */
    public Libro obtenerLibro(String isbn) {
        Libro libroEncontrado = null;
        for(Libro libro : listaLibros) {
            if(libro.getIsbn().equals(isbn)) {
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    /**
     * 
     * @param isbn
     * @param titulo
     * @param autor
     * @return
     * @throws Exception
     */
    public String crearLibro(String isbn, String titulo, String autor) throws Exception {
        String mensaje = "El libro ha sido creado";
        Libro libroEncontrado = obtenerLibro(isbn);
        if(libroEncontrado != null) {
            throw new Exception("El libro ya existe");
        } else {
            Libro libroNuevo = new Libro(isbn, titulo, autor);
            listaLibros.add(libroNuevo);
        }
        return mensaje;
    }

    /**
     * 
     * @param isbn
     * @return Elimina el libro al que le corresponda el isbn
     * @throws Exception
     */
    public String eliminarLibro(String isbn) throws Exception {
        String mensaje = "El libro ha sido eliminado";
        Libro libroEncontrado = obtenerLibro(isbn);
        if(libroEncontrado == null) {
            throw new Exception("El empleado no está registrado");
        }
        listaLibros.remove(libroEncontrado);
        return mensaje;
    }

    /**
     * 
     * @param isbn
     * @param titulo
     * @param autor
     * @return Actualiza los datos del libro si este existe
     * @throws Exception
     */
    public String actualizarLibro(String isbn, String titulo, String autor) throws Exception {
        String mensaje = "Los datos del libro han sido actualizados";
        Libro libroEncontrado = obtenerLibro(isbn);
        if(libroEncontrado == null) {
            throw new Exception("El libro no está registrado");
        }
        libroEncontrado.setAutor(titulo);
        libroEncontrado.setAutor(autor);
        return mensaje;
    }

    /**
     * 
     * @param codigo
     * @return El prestamo que le corresponde al codigo
     */
    public Prestamo obtenerPrestamo(String codigo) {
        Prestamo prestamoEncontrado = null;
        for(Prestamo prestamo : listaPrestamos) {
            if(prestamo.getCodigo().equals(codigo)) {
                prestamoEncontrado = prestamo;
            }
        }
        return prestamoEncontrado;
    }

    /**
     * 
     * @param fecha
     * @param total
     * @param tiempoEntrega
     * @param codigo
     * @return Da un mensaje positivo si el prestamo se pudo crear
     * @throws Exception
     */
    /*public String crearPrestamo(String fecha, double total, int tiempoEntrega, String codigo) throws Exception {
        String mensaje = "El prestamo ha sido creado";
        Prestamo prestamoEncontrado = obtenerPrestamo(codigo);
        if(prestamoEncontrado != null) {
            throw new Exception("El prestamo ya existe");
        } else {
            Prestamo prestamoNuevo = new Prestamo(fecha, total, tiempoEntrega, codigo);
            listaPrestamos.add(prestamoNuevo);
        }
        return mensaje;
    }*/

    /**
     * 
     * @param codigo
     * @return Mensaje postivo si se logra eliminar el prestamo
     * @throws Exception
     */
    public String eliminarPrestamo(String codigo) throws Exception {
        String mensaje = "El prestamo ha sido eliminado";
        Prestamo prestamoEncontrado = obtenerPrestamo(codigo);
        if(prestamoEncontrado == null) {
            throw new Exception("El prestamo no está registrado");
        }
        listaPrestamos.remove(prestamoEncontrado);
        return mensaje;
    }

    /**
     * 
     * @param fecha
     * @param total
     * @param tiempoEntrega
     * @param codigo
     * @return Mensaje positivo si se logra actualizar la info del prestamo
     * @throws Exception
     */
    public String actualizarPrestamo(String fecha, double total, int tiempoEntrega, String codigo) throws Exception {
        String mensaje = "Los datos del prestamo han sido actualizados";
        Prestamo prestamoEncontrado = obtenerPrestamo(codigo);
        if(prestamoEncontrado == null) {
            throw new Exception("El prestamo no está registrado");
        }
        prestamoEncontrado.setFecha(fecha);
        prestamoEncontrado.setTotal(total);
        prestamoEncontrado.setTiempoEntrega(tiempoEntrega);
        return mensaje;
    }

    /**
     * 
     * @param codigo
     * @return el detalle del prestamo dado el isbn del libro que le corresponde al detalle del prestamo
     */
    public DetallePrestamo obtenerDetallePrestamo(String isbn) {
        DetallePrestamo detallePrestamoEncontrado = null;
        for(DetallePrestamo detallePrestamo : listaDetallesPrestamos) {
            if(detallePrestamo.getLibro().getIsbn().equals(isbn)) {
                detallePrestamoEncontrado = detallePrestamo;
            }
        }
        return detallePrestamoEncontrado;
    }


    //SOLUCIÓN DE PUNTOS DEL TALLER

    //Dado el isbn de un libro tengo que dar la info del empleado que hizo el prestamo
    public Empleado obtenerInfoEmpleadoPrestamo(String isbn) throws Exception {
        for(Empleado empleado : listaEmpleados) {
            if(empleado.verificarPrestamoIsbn(isbn)) {
                return empleado;
            }
        }
        return null;
    }

    //Devuelve el prestamo que contiene la cantidad de unidades prestadas de un libro >=5 y <=15 unidades
    //realizado por un empleado de más de 2 años de experiencia
    public Prestamo obtenerPrestamoUnidadEmpleado() throws Exception {
        for(Prestamo prestamo : listaPrestamos) {
            if(prestamo.verificarEmpleadoUnidad()) {
                return prestamo;
            }
        }
        return null;
    }



    
}
