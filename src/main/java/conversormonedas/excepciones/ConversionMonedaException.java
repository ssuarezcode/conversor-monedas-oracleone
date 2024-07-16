package conversormonedas.excepciones;

public class ConversionMonedaException extends RuntimeException {
    public ConversionMonedaException(String message) {
        super(message);
    }
}

