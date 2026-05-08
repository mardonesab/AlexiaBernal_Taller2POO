import java.util.List;

public class Gimnasio 
{
	private String nombreLider;
    private List<Pokemon> equipoLider;
    private boolean derrotado;

    public Gimnasio(String nombreLider, List<Pokemon> equipoLider) {
        this.nombreLider = nombreLider;
        this.equipoLider = equipoLider;
        this.derrotado = false;
    }

    public String getNombreLider() { return nombreLider; }
    public List<Pokemon> getEquipoLider() { return equipoLider; }
    public boolean isDerrotado() { return derrotado; }
    public void setDerrotado(boolean derrotado) { this.derrotado = derrotado; }

    @Override
    public String toString() {
        return nombreLider + " - " + (derrotado ? "Derrotado" : "Pendiente");
    }
}
