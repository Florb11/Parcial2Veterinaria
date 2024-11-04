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
    public void examinarAnimal(Animal animal) {
        JOptionPane.showMessageDialog(null, "Examinando a " + animal.getNombre());
        animal.examinarAnimal();
        if (!animal.isEstadoSalud()) {
            JOptionPane.showMessageDialog(null,"El animal necesita tratamiento");
        }
    }
    public void curarAnimal(Animal animal){
        if(!animal.isEstadoSalud()){
            JOptionPane.showMessageDialog(null,"Aplicando tratamiento...");
            animal.agregarTratamiento();
            animal.setEstadoSalud(true);
        }else{
            JOptionPane.showMessageDialog(null,"No necesita tratamiento");
        }
    }
}
