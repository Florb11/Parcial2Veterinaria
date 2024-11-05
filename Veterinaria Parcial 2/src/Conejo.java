import javax.swing.*;

public class Conejo extends Animal{
    //Atributos
    private boolean ojos;

    //Constructor

    public Conejo(String nombre, int edad, double peso) {
        super(nombre, edad, peso);
        this.ojos = false;

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
        super.examinarAnimal();
        examinarOjos();
    }

    public void examinarOjos(){
        int ojos = JOptionPane.showConfirmDialog(null, "El animal tiene bien los ojos?");
        if (ojos == JOptionPane.YES_OPTION) {
            this.setEstadoSalud(true);
            JOptionPane.showMessageDialog(null, "los ojos del conejo estan bien");
        } else {
            this.setEstadoSalud(false);
            JOptionPane.showMessageDialog(null, "los ojos del conejo estan mal, Se necesita tratamiento");
        }
    }
}
