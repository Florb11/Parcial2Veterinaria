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
        this.veterinario=veterinario;
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

    public Animal registrarInfoBasica() {
        String[] opcionesAnimales = {"Perro", "Gato", "Conejo"};
        int opcionAnimal = JOptionPane.showOptionDialog(null,
                "Seleccione el tipo de animal:",
                "Registro de Mascota",
                0,
                0,
                null,
                opcionesAnimales,
                opcionesAnimales[0]);

        String nombre = validarNombre("Ingrese el nombre de su mascota:");
        int edad = validarNumeros("Ingrese la edad de su mascota:");
        double peso = validarNumeros("Ingrese el peso de su mascota:");


        switch (opcionAnimal) {
            case 0:
                Perro perro = new Perro(nombre, edad, peso);
                JOptionPane.showMessageDialog(null, "Su perro se ha registrado!\n" + perro);
                return perro;
            case 1:
                Gato gato = new Gato(nombre, edad, peso);
                JOptionPane.showMessageDialog(null, "Su gato se ha registrado!\n" + gato);
                return gato;
            case 2:
                Conejo conejo = new Conejo(nombre, edad, peso);
                JOptionPane.showMessageDialog(null, "Su conejo se ha registrado!\n" + conejo);
                return conejo;
        }
        return null;
    }
    public void asignarVet(){
        if (this.veterinario == null){
            setVeterinario(new Veterinario("el veterinario pepe","ser buena onda"));
            JOptionPane.showMessageDialog(null,"El veterinario de su mascota sera: "+ veterinario.getNombre());
        }else{
            JOptionPane.showMessageDialog(null,"ya hay vet");
        }
    }







}
