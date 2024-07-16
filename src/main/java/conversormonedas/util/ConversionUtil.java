package conversormonedas.util;

import conversormonedas.excepciones.ConversionMonedaException;
import conversormonedas.servicio.ConversionMoneda;

import java.util.Scanner;

public class ConversionUtil {

    public static void realizarConversion(Scanner scanner, ConversionMoneda conversion, String monedaDestino) throws ConversionMonedaException {
        System.out.println("Ingrese el monto a convertir:");
        double monto = Double.parseDouble(scanner.nextLine().trim());

        double resultado = conversion.convertir(monto, monedaDestino);
        System.out.printf("%.2f %s equivale a %.2f %s.%n", monto, conversion.getNombreMoneda(conversion.getMonedaBase()), resultado, monedaDestino);
    }

    public static void realizarConversion(Scanner scanner, ConversionMoneda conversion, String monedaOrigen, String monedaDestino) throws ConversionMonedaException {
        System.out.println("Ingrese el monto a convertir:");
        double monto = Double.parseDouble(scanner.nextLine().trim());

        double resultado = conversion.convertirDesde(monedaOrigen, monto, monedaDestino);
        System.out.printf("%.2f %s equivale a %.2f %s.%n", monto, conversion.getNombreMoneda(monedaOrigen), resultado, conversion.getNombreMoneda(monedaDestino));
    }
}




