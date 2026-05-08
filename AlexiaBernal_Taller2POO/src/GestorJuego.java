import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}
