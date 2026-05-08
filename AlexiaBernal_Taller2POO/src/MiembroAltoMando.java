import java.util.List;

public class MiembroAltoMando 
{
	private String nombre;
    private List<Pokemon> equipo;

    public MiembroAltoMando(String nombre, List<Pokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() { return nombre; }
    public List<Pokemon> getEquipo() { return equipo; }

    @Override
    public String toString() {
        return "Miembro Alto Mando: " + nombre;
    }
}
