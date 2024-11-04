import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Veterinaria vet = new Veterinaria("Patitas felices");
        String[] opciones = {"Registrar Mascota", "Agendar Turno", "Verificar Turno", "Salir"};
        int opcion;
        Animal animal = null;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Menu articulos",
                    "",
                    0,
                    0,
                    null,
                    opciones,
                    opciones[0]);
            switch (opcion) {
                case 0:
                    if(animal == null){
                        animal = vet.registrarInfoBasica();
                        vet.asignarVet();
                    }else{
                        JOptionPane.showMessageDialog(null,"Su mascota ya estaba registrada: " +animal);
                    }
                    break;
                case 1:
                    vet.programarTurno(animal);
                    break;
                case 2:
                    vet.verificarTurnos();

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    break;
            }
        } while (opcion != 2);

    }
}

