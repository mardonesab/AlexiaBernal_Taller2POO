
public class Main {

	public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ¡POKÉMON - CAMINO PARA SER EL MEJOR!   ");
        System.out.println("=========================================\n");

        Pokemon pikachu = new Pokemon("Pikachu", "Prado", 25.0, 60, 55, 40, 50, 50, 90, "ELÉCTRICO");
        System.out.println("Pokémon de prueba: " + pikachu);
        System.out.println("Suma de stats: " + pikachu.getSumaStats());
        System.out.println("Info completa: " + pikachu.getInfoCompleta());

    }

}
