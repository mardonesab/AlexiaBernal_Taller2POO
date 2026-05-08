import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GestorJuego 
{
	private Jugador jugador;
    private List<Pokemon> pokedex;           // Todos los Pokémon disponibles
    private List<String> habitats;           // Zonas para capturar
    private List<Gimnasio> gimnasios;
    private List<MiembroAltoMando> altoMando;
    private Random random;

    public GestorJuego() {
        this.pokedex = new ArrayList<>();
        this.habitats = new ArrayList<>();
        this.gimnasios = new ArrayList<>();
        this.altoMando = new ArrayList<>();
        this.random = new Random();
    }

    // CARGA DE ARCHIVOS 

    public void cargarPokedex(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");
                if (datos.length >= 10) {
                    Pokemon p = new Pokemon(
                        datos[0],                    // nombre
                        datos[1],                    // habitat
                        Double.parseDouble(datos[2]),// %
                        Integer.parseInt(datos[3]),  // vida
                        Integer.parseInt(datos[4]),  // ataque
                        Integer.parseInt(datos[5]),  // defensa
                        Integer.parseInt(datos[6]),  // atq esp
                        Integer.parseInt(datos[7]),  // def esp
                        Integer.parseInt(datos[8]),  // velocidad
                        datos[9]                     // tipo
                    );
                    pokedex.add(p);
                }
            }
            System.out.println("Pokedex cargada: " + pokedex.size() + " Pokémon");
        } catch (IOException e) {
            System.out.println("Error al cargar Pokedex: " + e.getMessage());
        }
    }

    public void cargarHabitats(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    habitats.add(linea.trim());
                }
            }
            System.out.println("Hábitats cargados: " + habitats.size());
        } catch (IOException e) {
            System.out.println("Error al cargar Hábitats: " + e.getMessage());
        }
    }

    // por ahora solo imprimimos que se cargaron (los implementaremos completo después)
    public void cargarGimnasios(String ruta) {
        System.out.println("Gimnasios cargados (implementación completa despues)");
    }

    public void cargarAltoMando(String ruta) {
        System.out.println("Alto Mando cargado (implementación completa despues)");
    }

    // MÉTODOS BÁSICOS 

    public void iniciarNuevaPartida(String nombreJugador) {
        jugador = new Jugador(nombreJugador);
        System.out.println("\n¡Bienvenido, " + nombreJugador + "! Nueva aventura comienza.");
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<String> getHabitats() {
        return habitats;
    }

    public List<Pokemon> getPokedex() {
        return pokedex;
    }
    
    
    // CARGA DE REGISTROS (Continuar Partida) 
    public boolean cargarPartida(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // Primera línea: nombre;medallas
            if (linea != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                int medallas = Integer.parseInt(datos[1]);

                jugador = new Jugador(nombre);
                jugador.agregarMedalla(); // se ajusta después según cantidad real

                // Cargar Pokémon del jugador (las siguientes líneas)
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    // por ahora solo mostramos
                    System.out.println("   → " + linea);
                }
                System.out.println("\nPartida cargada correctamente. Bienvenido de nuevo, " + nombre + "!");
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se encontró partida guardada o error al cargar.");
        }
        return false;
    }

    // MENÚ PRINCIPAL 
    public void mostrarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1) Revisar equipo");
            System.out.println("2) Salir a capturar");
            System.out.println("3) Acceso al PC");
            System.out.println("4) Retar un gimnasio");
            System.out.println("5) Desafío al Alto Mando");
            System.out.println("6) Curar Pokémon");
            System.out.println("7) Guardar");
            System.out.println("8) Guardar y Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    jugador.mostrarEquipo();
                    break;
                case 2:
                    System.out.println("Opción de captura en desarrollo...");
                    break;
                case 8:
                    System.out.println("¡Hasta la próxima, " + jugador.getNombre() + "!");
                    return;
                default:
                    System.out.println("Opción no implementada aún.");
            }
        } while (opcion != 8);
    }
}
