public class Conejo extends Animal{
    //Atributos
    private String tipoPelaje;

    //Constructor

    public Conejo(String nombre, int edad, double peso, String tipoPelaje) {
        super(nombre, edad, peso);
        this.tipoPelaje = tipoPelaje;
    }


    //Get y Set

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }


    //

    @Override
    public String toString() {
        return "Conejo{" +
                "tipoPelaje='" + tipoPelaje + '\'' +
                "} " + super.toString();
    }
}
