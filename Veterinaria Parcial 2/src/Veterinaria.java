public class Veterinaria {
    //Atributos
    private String nombre;

    //Constructor

    public Veterinaria(String nombre) {
        this.nombre = nombre;
    }
    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //

    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
