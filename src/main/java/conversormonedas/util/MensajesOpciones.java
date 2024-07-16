package conversormonedas.util;

public class MensajesOpciones {

    public static String obtenerMensaje() {
        return String.format("""
                ****************************************
                *** Selecciona la moneda a convertir ***

                1  - Pesos [COP] a Dólares [USD]
                2  - Pesos [COP] a Euros [EUR]
                3  - Pesos [COP] a Libras [GBP]
                4  - Pesos [COP] a Yen [JPY]
                5  - Pesos [COP] a Won Coreano [KRW]
                
                6  - Dólares [USD] a Pesos [COP]
                7  - Euros [EUR] a Pesos [COP]
                8  - Libras [GBP] a Pesos [COP]
                9  - Yen [JPY] a Pesos [COP]
                10 - Won Coreano [KRW]a Pesos [COP]
                
                11 - Salir                
                ****************************************
                """);
    }
}
