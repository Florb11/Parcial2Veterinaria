public class Perro extends Animal {
    //Atributos
    private String raza;

    //Constructor

    public Perro(String nombre, int edad, double peso, String raza) {
        super(nombre, edad, peso);
        this.raza = raza;
    }


    //Get y Set

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                "} " + super.toString();
    }
}
