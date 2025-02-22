/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class Programaescolar {

    // Clase Materia
    static class Materia {
        private String nombre;
        private String clave;
        private int creditos;
        private int horasSemanales;

        // Constructor por defecto
        public Materia() {}

        // Constructor con parámetros
        public Materia(String nombre, String clave, int creditos, int horasSemanales) {
            this.nombre = nombre;
            this.clave = clave;
            this.creditos = creditos;
            this.horasSemanales = horasSemanales;
        }

        // Constructor de copia
        public Materia(Materia otra) {
            this.nombre = otra.nombre;
            this.clave = otra.clave;
            this.creditos = otra.creditos;
            this.horasSemanales = otra.horasSemanales;
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public int getCreditos() {
            return creditos;
        }

        public void setCreditos(int creditos) {
            this.creditos = creditos;
        }

        public int getHorasSemanales() {
            return horasSemanales;
        }

        public void setHorasSemanales(int horasSemanales) {
            this.horasSemanales = horasSemanales;
        }

        @Override
        public String toString() {
            return nombre + " (Clave: " + clave + ", Créditos: " + creditos + ", Horas semanales: " + horasSemanales + ")";
        }
    }

    // Clase Profesor
    static class Profesor {
        private String nombre;
        private String numeroNomina;
        private double sueldoPorHora;
        private Materia materia;

        // Constructor por defecto
        public Profesor() {}

        // Constructor con parámetros
        public Profesor(String nombre, String numeroNomina, double sueldoPorHora, Materia materia) {
            this.nombre = nombre;
            this.numeroNomina = numeroNomina;
            this.sueldoPorHora = sueldoPorHora;
            this.materia = materia;
        }

        // Constructor de copia
        public Profesor(Profesor otro) {
            this.nombre = otro.nombre;
            this.numeroNomina = otro.numeroNomina;
            this.sueldoPorHora = otro.sueldoPorHora;
            this.materia = new Materia(otro.materia); // Copiar la materia
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNumeroNomina() {
            return numeroNomina;
        }

        public void setNumeroNomina(String numeroNomina) {
            this.numeroNomina = numeroNomina;
        }

        public double getSueldoPorHora() {
            return sueldoPorHora;
        }

        public void setSueldoPorHora(double sueldoPorHora) {
            this.sueldoPorHora = sueldoPorHora;
        }

        public Materia getMateria() {
            return materia;
        }

        public void setMateria(Materia materia) {
            this.materia = materia;
        }

        // Método para calcular sueldo semanal
        public double calcularSueldoSemanal() {
            return materia.getHorasSemanales() * sueldoPorHora;
        }

        @Override
        public String toString() {
            return "Profesor: " + nombre + ", Nómina: " + numeroNomina + ", Materia: " + materia.getNombre() +
                    ", Sueldo Semanal: " + calcularSueldoSemanal();
        }
    }

    // Clase Curso
    static class Curso {
        private String nombre;
        private Materia materia1;
        private Materia materia2;
        private Materia materia3;

        // Constructor por defecto
        public Curso() {}

        // Constructor con parámetros
        public Curso(String nombre, Materia materia1, Materia materia2, Materia materia3) {
            this.nombre = nombre;
            this.materia1 = materia1;
            this.materia2 = materia2;
            this.materia3 = materia3;
        }

        // Constructor de copia
        public Curso(Curso otro) {
            this.nombre = otro.nombre;
            this.materia1 = new Materia(otro.materia1);
            this.materia2 = new Materia(otro.materia2);
            this.materia3 = new Materia(otro.materia3);
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Materia getMateria1() {
            return materia1;
        }

        public void setMateria1(Materia materia1) {
            this.materia1 = materia1;
        }

        public Materia getMateria2() {
            return materia2;
        }

        public void setMateria2(Materia materia2) {
            this.materia2 = materia2;
        }

        public Materia getMateria3() {
            return materia3;
        }

        public void setMateria3(Materia materia3) {
            this.materia3 = materia3;
        }

        public int getCreditosTotales() {
            return materia1.getCreditos() + materia2.getCreditos() + materia3.getCreditos();
        }

        @Override
        public String toString() {
            return "Curso: " + nombre + ", Créditos Totales: " + getCreditosTotales();
        }
    }

    // Clase Alumno
    static class Alumno {
        private String matricula;
        private String nombre;
        private int edad;
        private Curso curso;

        // Constructor por defecto
        public Alumno() {}

        // Constructor con parámetros
        public Alumno(String matricula, String nombre, int edad, Curso curso) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.edad = edad;
            this.curso = curso;
        }

        // Constructor de copia
        public Alumno(Alumno otro) {
            this.matricula = otro.matricula;
            this.nombre = otro.nombre;
            this.edad = otro.edad;
            this.curso = new Curso(otro.curso); // Copiar el curso
        }

        // Getters y setters
        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public Curso getCurso() {
            return curso;
        }

        public void setCurso(Curso curso) {
            this.curso = curso;
        }

        @Override
        public String toString() {
            return "Alumno: " + nombre + " (" + matricula + "), Edad: " + edad + ", Curso: " + curso.getNombre();
        }
    }

    // Clase Main (ProgramaEscolar)
    public static void main(String[] args) {
        // Crear materias
        Materia mat1 = new Materia("Matemáticas", "MAT101", 5, 6);
        Materia mat2 = new Materia("Física", "FIS101", 4, 5);
        Materia mat3 = new Materia("Química", "QUI101", 4, 5);

        // Crear curso
        Curso curso = new Curso("Ciencias Básicas", mat1, mat2, mat3);

        // Crear un profesor
        Profesor profe = new Profesor("Juan Pérez", "1234", 200, mat1);

        // Crear un alumno
        Alumno alumno = new Alumno("A001", "Carlos López", 20, curso);

        // Mostrar información
        System.out.println(profe); // Mostrar profesor
        System.out.println(alumno); // Mostrar alumno
        System.out.println(curso); // Mostrar curso
    }
}
