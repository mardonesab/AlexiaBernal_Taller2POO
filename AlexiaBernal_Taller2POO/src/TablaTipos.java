
public class TablaTipos 
{
	// Matriz de efectividad (fila = atacante, columna = defensor)
    private static final double[][] EFECTIVIDAD = {
        // NOR  FUE  AGU  PLA  ELE  HIE  LUC  VEN  TIE  PSI  BIC  ROC  FAN  DRA  ACE  SIN  HAD
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 0.5, 1.0, 1.0}, // NORMAL
        {1.0, 0.5, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0}, // FUEGO
        {1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0}, // AGUA
        {1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0}, // PLANTA
        {1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0}, // ELÉCTRICO
        {1.0, 0.5, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0}, // HIELO
        {2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 2.0, 0.0, 1.0, 2.0, 1.0, 0.5}, // LUCHA
        {1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 2.0, 1.0}, // VENENO
        {1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0}, // TIERRA
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0}, // PSÍQUICO
        {1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0}, // BICHO
        {0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0}, // ROCA
        {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0}, // FANTASMA
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.0}, // DRAGÓN
        {0.5, 0.5, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0}, // ACERO
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5}, // SINIESTRO
        {1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 0.5, 2.0, 1.0}  // HADA
    };

    private static final String[] TIPOS = {"NORMAL","FUEGO","AGUA","PLANTA","ELÉCTRICO","HIELO",
                                           "LUCHA","VENENO","TIERRA","PSÍQUICO","BICHO","ROCA",
                                           "FANTASMA","DRAGÓN","ACERO","SINIESTRO","HADA"};

    public static double getEfectividad(String tipoAtacante, String tipoDefensor) {
        int indexAtacante = getIndex(tipoAtacante);
        int indexDefensor = getIndex(tipoDefensor);
        if (indexAtacante == -1 || indexDefensor == -1) return 1.0;
        return EFECTIVIDAD[indexAtacante][indexDefensor];
    }

    private static int getIndex(String tipo) {
        for (int i = 0; i < TIPOS.length; i++) {
            if (TIPOS[i].equalsIgnoreCase(tipo)) {
                return i;
            }
        }
        return -1;
    }
}
