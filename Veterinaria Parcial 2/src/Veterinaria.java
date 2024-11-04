import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class Veterinaria {
    //Atributos
    private String nombre;
    private LinkedList<Turno> turnos;

    //Constructor

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        this.turnos = new LinkedList<>();
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
    //


    @Override
    public String toString() {
        return "Veterinaria{" +
                "nombre='" + nombre + '\'' +
                ", turnos=" + turnos +
                '}';
    }

    public void programarTurno(Animal animal, Veterinario veterinario) {
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
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                return;
        }

        Turno nuevoTurno = new Turno(fechaTurno, animal, veterinario);
        turnos.add(nuevoTurno);


        JOptionPane.showMessageDialog(null, "El turno esta programado para: " + nuevoTurno);
    }

    public void verificarTurnos() {
        if (turnos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay turnos programados");
            return;
        }
        for (Turno turno : turnos) {
            if (turno.getFecha().isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "El turno para " + turno.getAnimal().getNombre() + " ya paso");
            } else {
                Period tiempoRestante = Period.between(LocalDate.now(), turno.getFecha());
                JOptionPane.showMessageDialog(null, "Faltan " + tiempoRestante.getDays() + " dias para el turno de " + turno.getAnimal().getNombre());
            }
        }
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

    public static String validarNombre(String mensaje) {
        boolean flag;
        String validar;

        do {
            flag = true;
            validar = JOptionPane.showInputDialog(null, mensaje);
            while (validar.isEmpty()) {
                validar = JOptionPane.showInputDialog(null, "Error" + mensaje);
            }
            for (int i = 0; i < validar.length(); i++) {
                if (!Character.isAlphabetic(validar.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Ingresa el nombre, sin numeros");
                    flag = false;
                    break;
                }

            }

        } while (!flag);
        return validar;
    }

    public Perro registrarInfoPerro() {
        String nombre = validarNombre("Ingrese el nombre del perro:");
        int edad = validarNumeros("Ingrese la edad del perro:");
        double peso = validarNumeros("Ingrese el peso del perro:");
        Perro perro = new Perro(nombre, edad, peso);
        JOptionPane.showMessageDialog(null, "Su perro se ha registrado!\n" + perro);
        return perro;
    }

    public Gato registrarInfoGato() {
        String nombre = validarNombre("Ingrese el nombre del gato:");
        int edad = validarNumeros("Ingrese la edad del gato:");
        double peso = validarNumeros("Ingrese el peso del gato:");
        Gato gato = new Gato(nombre, edad, peso);
        JOptionPane.showMessageDialog(null, "Su gato se ha registrado!\n" + gato);
        return gato;
    }

    public Conejo registrarInfoConejo() {
        String nombre = validarNombre("Ingrese el nombre del conejo:");
        int edad = validarNumeros("Ingrese la edad del conejo:");
        double peso = validarNumeros("Ingrese el peso del conejo:");
        Conejo conejo = new Conejo(nombre, edad, peso);
        JOptionPane.showMessageDialog(null, "Su conejo se ha registrado!\n" + conejo);
        return conejo;
    }





}
