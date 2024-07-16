package conversormonedas.dto;

public class MonedaDTO {
    private String nombre;
    private double tasa;

    public MonedaDTO(String nombre, double tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasa() {
        return tasa;
    }
}
