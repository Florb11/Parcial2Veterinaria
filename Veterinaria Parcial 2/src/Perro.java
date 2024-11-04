import javax.swing.*;

public class Perro extends Animal {
    //Atributos
    private boolean patitas;

    //Constructor

    public Perro(String nombre, int edad, double peso) {
        super(nombre, edad, peso);
        this.patitas = patitas;
    }



    //Get y Set


    public boolean isPatitas() {
        return patitas;
    }

    public void setPatitas(boolean patitas) {
        this.patitas = patitas;
    }

    @Override
    public String toString() {
        return "Perro{" +
                ", patitas=" + patitas +
                "} " + super.toString();
    }

    @Override
    public void mostrarHistorial() {
        super.mostrarHistorial();
    }

    @Override
    public void agregarTratamiento() {
        super.agregarTratamiento();
    }

    @Override
    public void examinarAnimal() {
        int patas = JOptionPane.showConfirmDialog(null, "El animal tiene bien las patas?");
        if (patas == JOptionPane.YES_OPTION) {
            this.patitas = true;
            JOptionPane.showMessageDialog(null, "Las patitas del perro estan bien");
        } else {
            this.patitas = false;
            JOptionPane.showMessageDialog(null, "El perro tiene problemas en las patitas, Se necesita tratamiento");
        }

    }
}
