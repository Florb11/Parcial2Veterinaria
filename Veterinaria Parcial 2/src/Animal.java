import javax.swing.*;

public class Animal {
    //Atributos
    private String nombre;
    private int edad;
    private double peso;
    private boolean estadoSalud;
    private Historial historial;

    //Constructor

    public Animal(String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historial = new Historial();
    }


    //Get y Set

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public boolean isEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(boolean estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    //


    @Override
    public String toString() {
        return "Animal{" +
                "nombre= '" + nombre + '\'' +
                ", edad= " + edad +
                ", peso= " + peso +
                ", estadoSalud= " + estadoSalud +
                ", historial= " + historial +
                '}';
    }


    public void examinarAnimal() {
        JOptionPane.showMessageDialog(null, "Comenzando el examen...");
    }

}
