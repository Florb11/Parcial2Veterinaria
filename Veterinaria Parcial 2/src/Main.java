import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Veterinaria vet = new Veterinaria("Perritos felices:d");


        String[] opcionesAnimales = {
                "Perro", "Gato", "Conejo", "Salir"
        };

        int opcionMascota;
        do {
            opcionMascota = JOptionPane.showOptionDialog(null,
                    "Selecciona tu mascota",
                    "Menu Mascota",
                    0,
                    0,
                    null,
                    opcionesAnimales,
                    opcionesAnimales[0]);



            switch (opcionMascota) {
                case 0:
                    vet.registrarInfoPerro();
                    break;
                case 1:
                    vet.registrarInfoGato();
                    break;
                case 2:
                    vet.registrarInfoConejo();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;

            }
        }while (opcionMascota!=3);
    }
}



