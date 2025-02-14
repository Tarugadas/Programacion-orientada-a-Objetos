
package comprarproducto;

import java.util.InputMismatchException;
import java.util.Scanner;

class Producto {
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;
    
    public Producto(String codigo, String tipo, double costo, double impuesto) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.costo = costo;
        this.impuesto = impuesto;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getCosto() {
        return costo;
    }
    
    public double getImpuesto() {
        return impuesto;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    
    public void muestraProducto() {
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: " + costo);
        System.out.println("Impuesto: " + impuesto + "%");
    }
    
    public double calcularPrecio(double utilidad) {
        double precioAntesImpuesto = costo + (costo * utilidad / 100);
        double precioFinal = precioAntesImpuesto + (precioAntesImpuesto * impuesto / 100);
        return precioFinal;
    }
}

public class ComprarProducto {
    public static String compararProductos(Producto p1, Producto p2) {
        double precio1 = p1.calcularPrecio(5);
        double precio2 = p2.calcularPrecio(5);
        
        if (precio1 > precio2) {
            return "El producto con mayor precio es: " + p1.getTipo();
        } else {
            return "El producto con mayor precio es: " + p2.getTipo();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            Producto rasuradora = new Producto("456", "Rasuradora", 50, 16);
            Producto jabon = new Producto("328", "Jabón", 45, 16);
            
            System.out.println("Datos del primer producto:");
            rasuradora.muestraProducto();
            
            System.out.println("\nDatos del segundo producto:");
            jabon.muestraProducto();
            
            String resultado = compararProductos(rasuradora, jabon);
            System.out.println("\n" + resultado);
            
        } catch (InputMismatchException e) {
            System.out.println("Error en la entrada de datos. Asegúrese de ingresar valores numéricos donde corresponda.");
        }
    }
}
    

