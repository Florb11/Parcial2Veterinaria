import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class Veterinaria {
    //Atributos
    private String nombre;
    private LinkedList<Turno> turnos;
    private Veterinario veterinario;

    //Constructor

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        this.turnos = new LinkedList<>();
        this.veterinario = null;
    }


    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(LinkedList<Turno> turnos) {
        this.turnos = turnos;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    //


    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", turnos=" + turnos +
                ", veterinario=" + veterinario +
                '}';
    }

    public void programarTurno(Animal animal) {
        if (this.veterinario == null) {
            this.veterinario = new Veterinario("pepe","El veterinario");
        }
        Icon icon = new ImageIcon(""); // agregar imagen no olvidarme
        String[] opciones = {"Agendar de aca a 1 semana", "Agendar fecha personalizada", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(null,
                "¿Para cuando queres agendar el turno?",
                "Agendar Turno",
                0,
                0,
                icon,
                opciones,
                opciones[0]);

        LocalDate fechaTurno = null;

        switch (opcion) {
            case 0:
                fechaTurno = LocalDate.now().plusWeeks(1);
                break;
            case 1:
                boolean fechaValida = false;
                int anio, mes, dia;
                do {
                    anio = validarNumeros("Ingrese año:");
                    mes = validarNumeros("Ingrese mes:");
                    dia = validarNumeros("Ingrese día:");
                    if (validarFecha(anio, mes, dia)) {
                        fechaTurno = LocalDate.of(anio, mes, dia);
                        fechaValida = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "La fecha debe ser posterior a la fecha actual");
                    }
                } while (!fechaValida);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "No se agendo ningun turno.");
                return;
        }

        Turno nuevoTurno = new Turno(fechaTurno, animal, veterinario);
        turnos.add(nuevoTurno);


        JOptionPane.showMessageDialog(null, "El turno esta programado para: " + nuevoTurno + "\nVeterinario asignado: "+this.veterinario);
    }

    public void verificarTurnos() {
        if (this.turnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay turnos programados");
            return;
        }

        String mensaje = "";
        for (Turno turno : this.turnos) {
            if (turno.getFecha().isBefore(LocalDate.now())) {
                mensaje += "El turno para " + turno.getAnimal().getNombre() + " ya paso\n";
            } else {
                Period tiempoRestante = Period.between(LocalDate.now(), turno.getFecha());
                mensaje += "Faltan " + tiempoRestante.getDays() + " dias para el turno de " + turno.getAnimal().getNombre();
            }
        }


        JOptionPane.showMessageDialog(null, mensaje);
    }


    public boolean validarFecha(int anio, int mes, int dia) {
        LocalDate fechaIngresada = LocalDate.of(anio, mes, dia);
        return fechaIngresada.isAfter(LocalDate.now());

    }

    public int validarNumeros(String mensaje) {
        boolean flag;
        String num = "";
        do {
            flag = true;
            num = JOptionPane.showInputDialog(mensaje);
            while (num.isEmpty()) {
                num = JOptionPane.showInputDialog(mensaje);
            }
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i))) {
                    flag = false;
                    break;
                }
            }
        } while (!flag);

        return Integer.parseInt(num);
    }


}
