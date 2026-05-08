import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ¡POKÉMON - CAMINO PARA SER EL MEJOR!   ");
        System.out.println("=========================================\n");

        Scanner sc = new Scanner(System.in);
        GestorJuego gestor = new GestorJuego();

        // Cargar archivos
        gestor.cargarPokedex("datos/Pokedex.txt");
        gestor.cargarHabitats("datos/Habitats.txt");
        gestor.cargarGimnasios("datos/Gimnasios.txt");
        gestor.cargarAltoMando("datos/AltoMando.txt");

        System.out.print("\nIngresa tu nombre de entrenador: ");
        String nombre = sc.nextLine();

        gestor.iniciarNuevaPartida(nombre);

        gestor.getJugador().mostrarEquipo();

        
        sc.close();
    }

}
