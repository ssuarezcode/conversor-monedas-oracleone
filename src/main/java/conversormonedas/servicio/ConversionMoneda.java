package conversormonedas.servicio;


import conversormonedas.excepciones.ConversionMonedaException;

import java.util.HashMap;
import java.util.Map;

public class ConversionMoneda {
    private String monedaBase;
    private Map<String, Double> tasas;

    public ConversionMoneda(String monedaBase) {
        this.monedaBase = monedaBase;
        this.tasas = new HashMap<>();
    }

    public void cargarTasas(Map<String, Double> tasas) {
        this.tasas = tasas;
    }

    public double convertir(double monto, String monedaDestino) throws ConversionMonedaException {
        if (!tasas.containsKey(monedaDestino)) {
            throw new ConversionMonedaException("Moneda destino no encontrada: " + monedaDestino);
        }
        double tasaDestino = tasas.get(monedaDestino);
        return monto / tasaDestino;
    }

    public double convertirDesde(String monedaOrigen, double monto, String monedaDestino) throws ConversionMonedaException {
        if (!tasas.containsKey(monedaOrigen)) {
            throw new ConversionMonedaException("Moneda origen no encontrada: " + monedaOrigen);
        }
        if (!tasas.containsKey(monedaDestino)) {
            throw new ConversionMonedaException("Moneda destino no encontrada: " + monedaDestino);
        }
        double tasaOrigen = tasas.get(monedaOrigen);
        double tasaDestino = tasas.get(monedaDestino);
        double montoEnBase = monto / tasaOrigen;
        return montoEnBase * tasaDestino;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getNombreMoneda(String codigoMoneda) {
        // Aquí podrías implementar la lógica para devolver el nombre de la moneda según su código
        return codigoMoneda; // Ejemplo simple devolviendo el código como nombre
    }
}

