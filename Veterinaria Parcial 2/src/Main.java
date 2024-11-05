import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ImageIcon Icon = new ImageIcon("src/img/vet.png");
        ImageIcon Icon2 = new ImageIcon("src/img/vet2.png");

        String[] tipos = {"Perro", "Gato", "Conejo"};
        int tipoAnimal = JOptionPane.showOptionDialog(null, "Seleccione el tipo de animal",
                "Tipo de Animal",
                0,
                0,
                Icon,
                tipos,
                tipos[0]);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso:"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
        Animal animal = null;

        switch (tipoAnimal) {
            case 0:
                animal = new Perro(nombre,edad ,peso);
                break;
            case 1:
                animal = new Gato(nombre,edad ,peso);
                break;
            case 2:
                animal = new Conejo(nombre,edad ,peso);
                break;
        }

        Veterinario veterinario = new Veterinario("Dr. Juan", "Veterinario General", animal);
        Veterinaria veterinaria = new Veterinaria("Veterinaria Amigos Peludos");

        // Menú de opciones
        String[] opciones = {"Programar Turno", "Verificar Turnos", "Examinar Animal", "Curar Animal",
                "Agregar Tratamiento al Historial", "Mostrar Historial de Animal",
                "Cancelar Turno", "Salir"};

        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Elija una opcion",
                    "Menu Veterinaria",
                    0,
                    0,
                    Icon2,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0:
                    veterinaria.programarTurno(veterinario.getAnimal());
                    break;
                case 1:
                    veterinaria.verificarTurnos();
                    break;
                case 2:
                    veterinario.examinarAnimal(animal);
                    break;

                case 3:
                    veterinario.curarAnimal();
                    break;
                case 4:
                    veterinario.agregarTratamientoAlHistorial();
                    break;
                case 5:
                    veterinario.mostrarHistorialAnimal();
                    break;
                case 6:
                    veterinaria.cancelarTurno();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
            }
        } while (opcion != 7);
    }
}