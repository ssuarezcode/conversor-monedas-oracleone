package conversormonedas.util;

public class MensajesOpciones {

    public static String obtenerMensaje() {
        return String.format("""
                *** Selecciona la moneda a convertir ***

                1  - De Pesos a Dólares
                2  - De Pesos a Euros
                3  - De Pesos a Libras
                4  - De Pesos a Yen
                5  - De Pesos a Won Coreano
                6  - De Dólares a Pesos
                7  - De Euros a Pesos
                8  - De Libras a Pesos
                9  - De Yen a Pesos
                10 - De Won Coreano a Pesos
                11 - Salir
                """);
    }
}
