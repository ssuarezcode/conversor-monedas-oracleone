package conversormonedas;

import conversormonedas.api.ConsumoAPI;
import conversormonedas.excepciones.ConversionMonedaException;
import conversormonedas.servicio.ConversionMoneda;
import conversormonedas.util.ConversionUtil;
import conversormonedas.util.MensajesOpciones;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsumoAPI consumoAPI = new ConsumoAPI();

        // Definir la moneda base para las conversiones
        String monedaBase = "COP";
        ConversionMoneda conversion = new ConversionMoneda(monedaBase);

        // Leer la variable de entorno para la clave de API
        String apiKey = System.getenv("API_EXCHANGE");
        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("Error: La variable de entorno API_EXCHANGE no está definida.");
            return;
        }

        // Construir la URL de la API usando la clave de API
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;
        Map<String, Double> tasas = consumoAPI.obtenerValores(apiUrl);
        conversion.cargarTasas(tasas);

        while (true) {
            // Mostrar el mensaje de opciones
            String mensajeOpciones = MensajesOpciones.obtenerMensaje();
            System.out.println(mensajeOpciones);

            // Leer la opción ingresada por el usuario
            String opcion = scanner.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        ConversionUtil.realizarConversion(scanner, conversion, "USD");
                        break;
                    case "2":
                        ConversionUtil.realizarConversion(scanner, conversion, "EUR");
                        break;
                    case "3":
                        ConversionUtil.realizarConversion(scanner, conversion, "GBP");
                        break;
                    case "4":
                        ConversionUtil.realizarConversion(scanner, conversion, "JPY");
                        break;
                    case "5":
                        ConversionUtil.realizarConversion(scanner, conversion, "KRW");
                        break;
                    case "6":
                        ConversionUtil.realizarConversion(scanner, conversion, "COP", "USD");
                        break;
                    case "7":
                        ConversionUtil.realizarConversion(scanner, conversion, "COP", "EUR");
                        break;
                    case "8":
                        ConversionUtil.realizarConversion(scanner, conversion, "COP", "GBP");
                        break;
                    case "9":
                        ConversionUtil.realizarConversion(scanner, conversion, "COP", "JPY");
                        break;
                    case "10":
                        ConversionUtil.realizarConversion(scanner, conversion, "COP", "KRW");
                        break;
                    case "11":
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (ConversionMonedaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
