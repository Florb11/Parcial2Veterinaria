import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro("perrito",20,20);
        Veterinario veterinario = new Veterinario("Pepe", "Veterinario",perro);
        Veterinaria veterinaria = new Veterinaria("Buena pata");

        String[] opciones = { "Programar Turno", "Verificar Turnos", "Examinar Animal", "Curar Animal",
                "Agregar Tratamiento al Historial", "Mostrar Historial de Animal","cancelar Turno", "Salir"};

        int opcion;
        do {

            opcion = JOptionPane.showOptionDialog(null,
                    "Elija una opcion",
                    "Menu Veterinaria",
                    0,
                    0,
                    null,
                    opciones,
                    opciones[0]
            );


            switch (opcion) {
                case 0:
                    veterinaria.programarTurno(veterinario.getAnimal());
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, veterinaria.getTurnos().isEmpty() ? "No hay turnos programados" : "Hay turnos programados: " + veterinaria.getTurnos());
                    break;
                case 2:
                    String mensajeExamen = (veterinario.getAnimal() == null) ? "No hay animal" : "Examinando a " + veterinario.getAnimal().getNombre();
                    JOptionPane.showMessageDialog(null, mensajeExamen);
                    if (veterinario.getAnimal() != null) {
                        veterinario.examinarAnimal(veterinario.getAnimal());
                    break;
                    }
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
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

            }
        } while (opcion != 7);
    }
}