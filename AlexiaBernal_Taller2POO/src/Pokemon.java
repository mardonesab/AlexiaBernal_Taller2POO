
public class Pokemon 
{
    private String nombre;
    private String habitat;
    private double porcentajeAparicion;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private String tipo;
    private String estado; // "Vivo" o "Debilitado"

    public Pokemon(String nombre, String habitat, double porcentajeAparicion, 
                   int vida, int ataque, int defensa, int ataqueEspecial, 
                   int defensaEspecial, int velocidad, String tipo) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.porcentajeAparicion = porcentajeAparicion;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.estado = "Vivo";
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getHabitat() { return habitat; }
    public double getPorcentajeAparicion() { return porcentajeAparicion; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAtaqueEspecial() { return ataqueEspecial; }
    public int getDefensaEspecial() { return defensaEspecial; }
    public int getVelocidad() { return velocidad; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }

    // Setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // metodos importantes
    public int getSumaStats() {
        return vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad;
    }

    public void debilitar() {
        this.estado = "Debilitado";
    }

    public void curar() {
        this.estado = "Vivo";
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - " + estado + 
               " | Stats: " + getSumaStats();
    }

    // mostrar información detallada del equipo
    public String getInfoCompleta() {
        return String.format("%-15s Tipo: %-8s Estado: %-10s Stats Total: %d",
                nombre, tipo, estado, getSumaStats());
    }
}
