import javax.swing.*;

public class Veterinario {
    //Atributos
    private String nombre;
    private String especialidad;
    private Animal animal;


    //Constructor

    public Veterinario(String nombre, String especialidad,Animal animal) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.animal = animal;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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
    public void examinarAnimal() {
        if (this.animal != null) {
            JOptionPane.showMessageDialog(null, "Examinando a " + this.animal.getNombre());
            this.animal.examinarAnimal();
            if (!this.animal.isEstadoSalud()) {
                JOptionPane.showMessageDialog(null, "El animal necesita tratamiento");
            } else {
                JOptionPane.showMessageDialog(null, "El animal esta en buen estado de salud");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal");
        }
    }
    //curar completo
    public void curarAnimal() {
        if (this.animal != null) {
            if (!this.animal.isEstadoSalud()) {
                JOptionPane.showMessageDialog(null, "Aplicando tratamiento a " + this.animal.getNombre());
                this.animal.setEstadoSalud(true);
                agregarTratamientoAlHistorial();
                JOptionPane.showMessageDialog(null, "Tratamiento aplicado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No necesita tratamiento");
            }
        } else {
            JOptionPane.showMessageDialog(null, "no hay animal :c");
        }
    }
    //mostras completo
    public void mostrarHistorialAnimal() {
        if (this.animal != null) {
            this.animal.getHistorial().mostrarHistorial();
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal");
        }
    }
    //
    public void agregarTratamientoAlHistorial() {
        if (this.animal != null) {
            this.animal.getHistorial().agregarTratamientoHistorial();
        } else {
            JOptionPane.showMessageDialog(null, "No hay animal para agregar tratamiento al historial");
        }
    }





}
