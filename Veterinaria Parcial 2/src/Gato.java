import javax.swing.*;

public class Gato extends Animal{
    //Atributos
    private boolean pelaje;

    //Constructor

    public Gato(String nombre, int edad, double peso) {
        super(nombre, edad, peso);
        this.pelaje=true;

    }


    //Get y Set

    public boolean isPelaje() {
        return pelaje;
    }

    public void setPelaje(boolean pelaje) {
        this.pelaje = pelaje;
    }

    //

    @Override
    public String toString() {
        return "Gato{" +
                "pelaje='" + pelaje + '\'' +
                "} " + super.toString();
    }

    @Override
    public void examinarAnimal() {
        super.examinarAnimal();
        examinarPelaje();
    }
    public void examinarPelaje(){
        int pelaje = JOptionPane.showConfirmDialog(null, "El animal tiene bien el pelaje?");
        if (pelaje == JOptionPane.YES_OPTION) {
            this.setEstadoSalud(true);
            JOptionPane.showMessageDialog(null, "El pelaje del gato esta bien");
        } else {
            this.setEstadoSalud(false);
            JOptionPane.showMessageDialog(null, "El gato tiene problemas en el pelaje, Se necesita tratamiento");
        }
    }
}
