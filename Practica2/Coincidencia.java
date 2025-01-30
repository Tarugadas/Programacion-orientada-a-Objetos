/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
import java.util.Scanner;
public class Coincidencia {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Escribe tu nombre: ");
        String nombre = scanner.nextLine();
        
        switch (nombre) {
            case "Eduardo":
                System.out.println("¡Bienvenido administrador del equipo!");
                break;
            case "Aaron":
                System.out.println("¡Hola, Invitado 1!");
                break;   
            default:
                System.out.println("Usuario no reconocido");
                scanner.close(); 
                break;
        
        }
   }
}