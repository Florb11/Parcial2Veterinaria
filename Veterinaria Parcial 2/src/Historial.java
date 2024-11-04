import java.util.LinkedList;

public class Historial {
    //Atributos
    private LinkedList<Tratamiento> tratamientos = new LinkedList<Tratamiento>();

    //Constructor

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
}
