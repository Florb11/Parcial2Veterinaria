import javax.swing.*;

public class Conejo extends Animal{
    //Atributos
    private boolean ojos;

    //Constructor

    public Conejo(String nombre, int edad, double peso) {
        super(nombre, edad, peso);
        this.ojos = ojos;
    }

    //Get y Set

    public boolean isOjos() {
        return ojos;
    }

    public void setOjos(boolean ojos) {
        this.ojos = ojos;
    }

    //

    @Override
    public String toString() {
        return "Conejo{" +
                "ojos=" + ojos +
                "} " + super.toString();
    }

    @Override
    public void examinarAnimal() {
        int ojos = JOptionPane.showConfirmDialog(null, "El animal tiene bien los ojos?");
        if (ojos == JOptionPane.YES_OPTION) {
            this.ojos = true;
            JOptionPane.showMessageDialog(null, "los ojos del conejo estan bien");
        } else {
            this.ojos = false;
            JOptionPane.showMessageDialog(null, "los ojos del conejo estan mal, Se necesita tratamiento");
            agregarTratamiento();
        }
    }

    @Override
    public void agregarTratamiento() {
        super.agregarTratamiento();
    }

    @Override
    public void mostrarHistorial() {
        super.mostrarHistorial();
    }
}
