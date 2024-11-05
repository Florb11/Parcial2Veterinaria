public class Tratamiento {
    //Atributos
    private String nombre;
    private String descripcion;

    //Constructor

    public Tratamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //

    @Override
    public String toString() {
        return "Tratamiento{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
