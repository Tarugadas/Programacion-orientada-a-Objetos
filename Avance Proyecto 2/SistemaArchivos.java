/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Clase principal para probar el sistema
public class SistemaArchivos {
    public static void main(String[] args) {
        // Crear algunos archivos
        Archivo archivo1 = new Archivo("Informe_2025", new Date(), "Contenido del informe...");
        Archivo archivo2 = new Archivo("Presentacion_Marzo", new Date(), "Contenido de la presentación...");

        // Crear usuarios
        Administrador admin = new Administrador("Juan Administrador");
        Trabajador trabajador1 = new Trabajador("Pedro Trabajador");

        // El administrador agrega archivos
        admin.agregarArchivo(archivo1);
        admin.agregarArchivo(archivo2);

        // Mostrar archivos antes de compartir
        System.out.println("Archivos de Admin:");
        admin.mostrarArchivos();

        // El administrador comparte el archivo con el trabajador
        admin.compartirArchivo(archivo1, trabajador1);

        // Mostrar archivos del trabajador después de compartir
        System.out.println("\nArchivos de Trabajador:");
        trabajador1.mostrarArchivos();

        // El administrador actualiza el contenido de un archivo
        admin.actualizarArchivo(archivo1, "Nuevo contenido actualizado del informe.");

        // Mostrar archivos después de la actualización
        System.out.println("\nArchivos de Admin después de actualización:");
        admin.mostrarArchivos();
    }
}

// Clase que representa un archivo
class Archivo {
    private String nombre;
    private Date fechaCreacion;
    private String contenido;

    public Archivo(String nombre, Date fechaCreacion, String contenido) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Archivo: " + nombre + ", Fecha: " + fechaCreacion + ", Contenido: " + contenido;
    }
}

// Clase base para el usuario
abstract class Usuario {
    protected String nombre;
    protected List<Archivo> archivos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.archivos = new ArrayList<>();
    }

    // Método para agregar archivos
    public void agregarArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    // Método para mostrar archivos (que puede ser modificado según tipo de usuario)
    public void mostrarArchivos() {
        for (Archivo archivo : archivos) {
            System.out.println(archivo);
        }
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase Administrador que tiene acceso completo a los archivos
class Administrador extends Usuario {

    public Administrador(String nombre) {
        super(nombre);
    }

    // Método para actualizar un archivo (cambiar su contenido)
    public void actualizarArchivo(Archivo archivo, String nuevoContenido) {
        archivo = new Archivo(archivo.getNombre(), archivo.getFechaCreacion(), nuevoContenido);
        System.out.println("Archivo actualizado: " + archivo.getNombre());
    }

    // Método para compartir un archivo con un trabajador
    public void compartirArchivo(Archivo archivo, Trabajador trabajador) {
        trabajador.agregarArchivo(archivo);
        System.out.println("Archivo compartido con el trabajador: " + archivo.getNombre());
    }
}

// Clase Trabajador que solo puede ver archivos
class Trabajador extends Usuario {

    public Trabajador(String nombre) {
        super(nombre);
    }

    // Método para ver archivos (no puede actualizar ni compartir)
    @Override
    public void mostrarArchivos() {
        super.mostrarArchivos();
    }
}
