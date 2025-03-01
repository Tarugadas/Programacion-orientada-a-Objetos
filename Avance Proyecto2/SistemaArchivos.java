import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Archivo: " + nombre + ", Fecha: " + fechaCreacion + ", Contenido: " + contenido;
    }
}

abstract class Usuario {
    protected String nombre;
    protected List<Archivo> archivos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.archivos = new ArrayList<>();
    }

    public void agregarArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    public void mostrarArchivos() {
        for (Archivo archivo : archivos) {
            System.out.println(archivo);
        }
    }

    public String getNombre() {
        return nombre;
    }
}

class Administrador extends Usuario {

    public Administrador(String nombre) {
        super(nombre);
    }

    public void actualizarArchivo(Archivo archivo, String nuevoContenido) {
        archivo.setContenido(nuevoContenido);
        System.out.println("Archivo actualizado: " + archivo.getNombre());
    }

    public void compartirArchivo(Archivo archivo, Trabajador trabajador) {
        trabajador.agregarArchivo(archivo);
        System.out.println("Archivo compartido con el trabajador: " + archivo.getNombre());
    }
}

class Trabajador extends Usuario {

    public Trabajador(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarArchivos() {
        super.mostrarArchivos();
    }
}

class BaseDeDatos {
    private List<Archivo> archivos;
    private List<Usuario> usuarios;

    public BaseDeDatos() {
        archivos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    public List<Archivo> obtenerArchivos() {
        return archivos;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}

public class SistemaArchivos {
    public static void main(String[] args) {
        BaseDeDatos baseDeDatos = new BaseDeDatos();

        Archivo archivo1 = new Archivo("Informe_2025", new Date(), "Contenido del informe...");
        Archivo archivo2 = new Archivo("Presentacion_Marzo", new Date(), "Contenido de la presentación...");

        Administrador admin = new Administrador("Juan Administrador");
        Trabajador trabajador1 = new Trabajador("Pedro Trabajador");

        baseDeDatos.agregarArchivo(archivo1);
        baseDeDatos.agregarArchivo(archivo2);

        baseDeDatos.agregarUsuario(admin);
        baseDeDatos.agregarUsuario(trabajador1);

        admin.agregarArchivo(archivo1);
        admin.agregarArchivo(archivo2);

        System.out.println("Archivos de Admin:");
        admin.mostrarArchivos();

        admin.compartirArchivo(archivo1, trabajador1);

        System.out.println("\nArchivos de Trabajador:");
        trabajador1.mostrarArchivos();

        admin.actualizarArchivo(archivo1, "Nuevo contenido actualizado del informe.");

        System.out.println("\nArchivos de Admin después de actualización:");
        admin.mostrarArchivos();

        System.out.println("\nTodos los archivos en la Base de Datos:");
        for (Archivo archivo : baseDeDatos.obtenerArchivos()) {
            System.out.println(archivo);
        }
    }
}
