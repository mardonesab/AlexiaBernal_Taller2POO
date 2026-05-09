import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ¡POKÉMON - CAMINO PARA SER EL MEJOR!   ");
        System.out.println("=========================================\n");

        GestorJuego gestor = new GestorJuego();

        // Carga de todos los archivos
        gestor.cargarPokedex("datos/Pokedex.txt");
        gestor.cargarHabitats("datos/Habitats.txt");
        gestor.cargarGimnasios("datos/Gimnasios.txt");
        gestor.cargarAltoMando("datos/AltoMando.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("1) Nueva Partida");
        System.out.println("2) Continuar Partida");
        System.out.print("Elige: ");
        
        int inicio = sc.nextInt();
        sc.nextLine();

        if (inicio == 2) {
            gestor.cargarPartida("datos/Registros.txt");
        } else {
            System.out.print("Ingresa tu nombre de entrenador: ");
            String nombre = sc.nextLine();
            gestor.iniciarNuevaPartida(nombre);
        }

        gestor.mostrarMenuPrincipal();
        sc.close();
    }

}
