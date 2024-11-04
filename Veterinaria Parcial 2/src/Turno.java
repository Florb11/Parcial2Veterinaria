import java.time.LocalDate;

public class Turno {
    //Atributos
    private LocalDate fecha;
    private Animal animal;
    private Veterinario veterinario;

    //Constructor

    public Turno(LocalDate fecha, Animal animal, Veterinario veterinario) {
        this.fecha = fecha;
        this.animal = animal;
        this.veterinario = veterinario;
    }


    //Get y Set

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }


    //

    @Override
    public String toString() {
        return "Turno{" +
                "fecha=" + fecha +
                ", animal=" + animal +
                ", veterinario=" + veterinario +
                '}';
    }


}
