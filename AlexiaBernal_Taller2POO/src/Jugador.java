import java.util.ArrayList;
import java.util.List;

public class Jugador 
{
	private String nombre;
    private int medallas;
    private List<Pokemon> equipo;      // Primeros 6 Pokémon (equipo de batalla)
    private List<Pokemon> pc;          // Resto de Pokémon capturados

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.medallas = 0;
        this.equipo = new ArrayList<>();
        this.pc = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public int getMedallas() { return medallas; }
    public void agregarMedalla() { this.medallas++; }

    public List<Pokemon> getEquipo() { return equipo; }
    public List<Pokemon> getPc() { return pc; }

    // agregar Pokémon al equipo o PC
    public void agregarPokemon(Pokemon p) {
        if (equipo.size() < 6) {
            equipo.add(p);
        } else {
            pc.add(p);
        }
    }

    // mostrar equipo
    public void mostrarEquipo() {
        System.out.println("\n=== EQUIPO DE " + nombre.toUpperCase() + " (" + medallas + " medallas) ===");
        if (equipo.isEmpty()) {
            System.out.println("No tienes Pokémon en tu equipo.");
            return;
        }
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println((i+1) + ". " + equipo.get(i).getInfoCompleta());
        }
    }

    // mostrar todos los Pokémon 
    public void mostrarTodosLosPokemon() {
        System.out.println("\n=== TODOS TUS POKÉMON (" + (equipo.size() + pc.size()) + ") ===");
        int contador = 1;
        
        System.out.println("--- EQUIPO (" + equipo.size() + "/6) ---");
        for (Pokemon p : equipo) {
            System.out.println(contador++ + ". " + p.getInfoCompleta());
        }
        
        if (!pc.isEmpty()) {
            System.out.println("\n--- PC (" + pc.size() + ") ---");
            for (Pokemon p : pc) {
                System.out.println(contador++ + ". " + p.getInfoCompleta());
            }
        }
    }

    @Override
    public String toString() {
        return nombre + ";" + medallas;
    }
}
