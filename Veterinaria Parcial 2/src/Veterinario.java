import javax.swing.*;

public class Veterinario {
    //Atributos
    private String nombre;
    private String especialidad;


    //Constructor

    public Veterinario(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }


    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    //

    @Override
    public String toString() {
        return "Veterinario{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
    // examinar completo
    public void examinarAnimal(Animal animal) {
        if (animal != null) {
            JOptionPane.showMessageDialog(null, "Examinando a " + animal.getNombre());
            animal.examinarAnimal();
            if (!animal.isEstadoSalud()) {
                JOptionPane.showMessageDialog(null, "El animal necesita tratamiento");
            } else {
                JOptionPane.showMessageDialog(null, "El animal esta en buen estado de salud");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal");
        }
    }
    //curar completo
    public void curarAnimal(Animal animal) {
        if (animal != null) {
            if (!animal.isEstadoSalud()) {
                JOptionPane.showMessageDialog(null, "Aplicando tratamiento a " + animal.getNombre());
                animal.setEstadoSalud(true);
                agregarTratamientoAlHistorial(animal);
                JOptionPane.showMessageDialog(null, "Tratamiento aplicado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No necesita tratamiento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "no hay animal :c");
        }
    }
    //mostras completo
    public void mostrarHistorialAnimal(Animal animal) {
        if (animal != null) {
            animal.getHistorial().mostrarHistorial();
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal");
        }
    }
    public void agregarTratamientoAlHistorial(Animal animal) {
        if (animal != null) {
            animal.getHistorial().agregarTratamientoHistorial();
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal para agregar tratamiento al historial");
        }
    }




}
