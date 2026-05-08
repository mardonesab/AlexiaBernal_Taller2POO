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

            switch (opcion) 
            {
            case 1:
                jugador.mostrarEquipo();
                break;
            case 2:
                mostrarHabitatsYCapturar();
                break;
            case 3:
                accesoAlPC();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                System.out.println("Esta opción se implementará despues.");
                break;
            case 8:
                System.out.println("¡Hasta la próxima, " + jugador.getNombre() + "!");
                return;
            default:
                System.out.println("Opción inválida.");
            }
            
        } while (opcion != 8);
    }
    
    
    //  SALIR A CAPTURAR 
    public void mostrarHabitatsYCapturar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== ZONAS DISPONIBLES ===");
        for (int i = 0; i < habitats.size(); i++) {
            System.out.println((i+1) + ". " + habitats.get(i));
        }
        System.out.print("Elige una zona: ");
        int zona = sc.nextInt() - 1;
        sc.nextLine();

        if (zona < 0 || zona >= habitats.size()) {
            System.out.println("Zona inválida.");
            return;
        }

        String habitatElegido = habitats.get(zona);
        Pokemon pokemonEncontrado = generarPokemonAleatorio(habitatElegido);

        if (pokemonEncontrado == null) {
            System.out.println("No se encontró ningún Pokémon en esta zona.");
            return;
        }

        System.out.println("\n¡Apareció un " + pokemonEncontrado.getNombre() + " (" + pokemonEncontrado.getTipo() + ")!");
        System.out.println("1) Capturar");
        System.out.println("2) Huir");
        System.out.print("Elige: ");
        int decision = sc.nextInt();
        sc.nextLine();

        if (decision == 1) {
            if (agregarPokemonAJugador(pokemonEncontrado)) {
                System.out.println("¡" + pokemonEncontrado.getNombre() + " ha sido capturado!");
            }
        } else {
            System.out.println("Huiste del encuentro.");
        }
    }

    private Pokemon generarPokemonAleatorio(String habitat) {
        List<Pokemon> candidatos = new ArrayList<>();
        for (Pokemon p : pokedex) {
            if (p.getHabitat().equalsIgnoreCase(habitat)) {
                candidatos.add(p);
            }
        }
        if (candidatos.isEmpty()) return null;

        // seleccion ponderada por porcentaje de aparición
        double total = 0;
        for (Pokemon p : candidatos) total += p.getPorcentajeAparicion();
        
        double randomValue = random.nextDouble() * total;
        double acumulado = 0;

        for (Pokemon p : candidatos) {
            acumulado += p.getPorcentajeAparicion();
            if (randomValue <= acumulado) {
                return new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(),
                        p.getVida(), p.getAtaque(), p.getDefensa(), p.getAtaqueEspecial(),
                        p.getDefensaEspecial(), p.getVelocidad(), p.getTipo());
            }
        }
        return candidatos.get(0); 
    }

    private boolean agregarPokemonAJugador(Pokemon nuevo) {
        // eevitar duplicados
        for (Pokemon p : jugador.getEquipo()) {
            if (p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                System.out.println("Ya tienes a " + nuevo.getNombre() + ".");
                return false;
            }
        }
        for (Pokemon p : jugador.getPc()) {
            if (p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                System.out.println("Ya tienes a " + nuevo.getNombre() + " en el PC.");
                return false;
            }
        }

        jugador.agregarPokemon(nuevo);
        return true;
    }

    //  ACCESO AL PC 
    public void accesoAlPC() {
        Scanner sc = new Scanner(System.in);
        jugador.mostrarTodosLosPokemon();

        System.out.println("\n1) Cambiar Pokémon de posición");
        System.out.println("2) Volver al menú");
        System.out.print("Elige: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            System.out.print("Ingresa posición del primer Pokémon: ");
            int pos1 = sc.nextInt() - 1;
            System.out.print("Ingresa posición del segundo Pokémon: ");
            int pos2 = sc.nextInt() - 1;
            sc.nextLine();

            List<Pokemon> todos = new ArrayList<>();
            todos.addAll(jugador.getEquipo());
            todos.addAll(jugador.getPc());

            if (pos1 >= 0 && pos1 < todos.size() && pos2 >= 0 && pos2 < todos.size()) {
                Pokemon temp = todos.get(pos1);
                todos.set(pos1, todos.get(pos2));
                todos.set(pos2, temp);

                // Reconstruir equipo y PC
                jugador.getEquipo().clear();
                jugador.getPc().clear();
                for (int i = 0; i < todos.size(); i++) {
                    if (i < 6) {
                        jugador.getEquipo().add(todos.get(i));
                    } else {
                        jugador.getPc().add(todos.get(i));
                    }
                }
                System.out.println("¡Pokémon intercambiados correctamente!");
            } else {
                System.out.println("Posiciones inválidas.");
            }
        }
    }
}
