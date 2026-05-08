import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ¡POKÉMON - CAMINO PARA SER EL MEJOR!   ");
        System.out.println("=========================================\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa tu nombre de entrenador: ");
        String nombre = sc.nextLine();

        Jugador jugador = new Jugador(nombre);

        // pokémon de prueba
        Pokemon pikachu = new Pokemon("Pikachu", "Prado", 25.0, 60, 55, 40, 50, 50, 90, "ELÉCTRICO");
        Pokemon charmander = new Pokemon("Charmander", "Montaña", 20.0, 70, 60, 50, 55, 45, 65, "FUEGO");

        jugador.agregarPokemon(pikachu);
        jugador.agregarPokemon(charmander);

        jugador.mostrarEquipo();
        jugador.mostrarTodosLosPokemon();

        
        sc.close();
    }

}
