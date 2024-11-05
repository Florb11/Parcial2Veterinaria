import javax.swing.*;
import java.util.LinkedList;

public class Historial {
    //Atributos
    private LinkedList<Tratamiento> tratamientos;

    //Constructor

    public Historial() {
        this.tratamientos = new LinkedList<Tratamiento>();
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
        String nombreTratamiento = validarNombre("Ingrese el nombre del tratamiento");
        String descripcionTratamiento = validarDescripcion("Ingrese una breve descripcion");

        for (Tratamiento trat : this.tratamientos) {
            if (trat.getNombre().equals(nombreTratamiento)) {
                trat.setDescripcion(descripcionTratamiento);
                JOptionPane.showMessageDialog(null, "Tratamiento actualizado: " + trat.getNombre());
                return;
            }
        }
        Tratamiento tratamiento1 = new Tratamiento(nombreTratamiento, descripcionTratamiento);
        tratamientos.add(tratamiento1);
        JOptionPane.showMessageDialog(null, "Tratamiento agregado: " + tratamiento1.getNombre());

    }
    public void mostrarHistorial() {
        if (tratamientos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tratamientos en el historial");
        } else {
            String historial = "Historial de tratamientos:\n";
            for (Tratamiento tratamiento : tratamientos) {
                historial +=  tratamiento + "\n";
            }
            JOptionPane.showMessageDialog(null, historial);
        }
    }

    public  String validarNombre(String mensaje) {
        boolean flag;
        String validar;

        do {
            flag = true;
            validar = JOptionPane.showInputDialog(null, mensaje);
            while (validar.isEmpty()) {
                validar = JOptionPane.showInputDialog(null, "Error" + mensaje);
            }
            for (int i = 0; i < validar.length(); i++) {
                if (!Character.isAlphabetic(validar.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Ingresa el nombre, sin numeros");
                    flag = false;
                    break;
                }

            }

        } while (!flag);
        return validar;
    }

    public String validarDescripcion(String mensaje) {
        String validar;
        do {
            validar = JOptionPane.showInputDialog(null, mensaje);
            if (validar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La descripcion no puede estar vacia: " + mensaje);
            }
        } while (validar.isEmpty());

        return validar;
    }

}
