import javax.swing.*;
import java.util.LinkedList;

public class Historial {
    //Atributos
    private LinkedList<Tratamiento> tratamientos = new LinkedList<Tratamiento>();

    //Constructor

    public Historial() {
        this.tratamientos = tratamientos;
    }

    public Historial(LinkedList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
    //Get y Set

    public LinkedList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(LinkedList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }


    //

    @Override
    public String toString() {
        return "Historial{" +
                "tratamientos=" + tratamientos +
                '}';
    }
    public void agregarTratamientoHistorial(){
        String nombreTratamiento= JOptionPane.showInputDialog("Ingrese el nombre del tratamiento");
        String descripcionTratamiento = JOptionPane.showInputDialog("Ingrese una breve descripcion");
        Tratamiento tratamiento1 = new Tratamiento(nombreTratamiento,descripcionTratamiento);
        boolean encontrado = false;

        for(Tratamiento trat : this.tratamientos){
            if(trat.getNombre().equals(nombreTratamiento)){
                trat.setDescripcion(descripcionTratamiento);
                encontrado = true;
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado" + trat.getNombre());
                break;
            }
        }
        if (!encontrado) {
            tratamientos.add(tratamiento1);
            JOptionPane.showMessageDialog(null, "Tratamiento agregado: " + tratamiento1.getNombre());
        }
    }
    public void mostrarHistorial(){
        for(Tratamiento trat: tratamientos){
            JOptionPane.showMessageDialog(null,tratamientos);
        }
    }
}
