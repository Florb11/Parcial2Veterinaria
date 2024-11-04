public class Gato extends Animal{
    //Atributos
    private String color;

    //Constructor

    public Gato(String nombre, int edad, double peso, String color) {
        super(nombre, edad, peso);
        this.color = color;
    }


    //Get y Set

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                "} " + super.toString();
    }
}
