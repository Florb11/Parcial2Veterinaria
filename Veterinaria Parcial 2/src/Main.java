import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Veterinario veterinario = new Veterinario("Dr. Juan", "Veterinario General");
        Veterinaria veterinaria = new Veterinaria("dsa");
        Perro perro = new Perro("fdsf",20,20);
        String[] opciones = { "Programar Turno", "Verificar Turnos", "Examinar Animal", "Curar Animal","Agregar Tratamiento al Historial", "Mostrar Historial de Animal", "Salir"
        };

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
                    veterinaria.programarTurno(perro);
                    break;
                case 1:
                    veterinaria.verificarTurnos();
                    break;
                case 2:
                    if(veterinaria.getTurnos()==null){
                        JOptionPane.showMessageDialog(null,"agenda primero");
                    }else {
                        veterinario.examinarAnimal(perro);
                    }
                    break;
                case 3:
                    veterinario.curarAnimal(perro);
                    break;
                case 4:
                    veterinario.agregarTratamientoAlHistorial(perro);
                    break;
                case 5:
                    veterinario.mostrarHistorialAnimal(perro);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

            }
        } while (opcion != 6);
    }
}