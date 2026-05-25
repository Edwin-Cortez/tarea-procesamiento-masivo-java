import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcesadorOptimizado {

    public static void procesar(List<Cliente> clientes) {
        // Estructura optimizada solicitada en la rúbrica
        Map<String, List<Cliente>> campanias = new HashMap<>();

        long inicio = System.currentTimeMillis();

        for (Cliente cliente : clientes) {
            String tipo = determinarCampania(cliente);

            // computeIfAbsent realiza la búsqueda e inserción en tiempo constante O(1)
            campanias.computeIfAbsent(tipo, k -> new ArrayList<>()).add(cliente);
        }

        long fin = System.currentTimeMillis();

        System.out.println("\nResumen de campañas generadas (Optimizado):");
        System.out.println("Total de campañas diferentes: " + campanias.size());
        campanias.forEach((tipo, lista) -> {
            System.out.println(tipo + ": " + lista.size());
        });
        System.out.println("\nTiempo de procesamiento OPTIMIZADO: " + (fin - inicio) + " ms");
    }

    private static String determinarCampania(Cliente cliente) {
        String nivelIngreso = (cliente.getIngreso() >= 25000) ? "INGRESO_ALTO" : (cliente.getIngreso() >= 15000) ? "INGRESO_MEDIO" : (cliente.getIngreso() >= 10000) ? "INGRESO_BAJO" : "NO_APLICA";
        String nivelScore = (cliente.getScore() >= 800) ? "SCORE_EXCELENTE" : (cliente.getScore() >= 600) ? "SCORE_BUENO" : (cliente.getScore() >= 400) ? "SCORE_REGULAR" : "SCORE_RIESGO";
        String nivelDeuda = (cliente.getDeuda() >= 7000) ? "DEUDA_ALTA" : (cliente.getDeuda() >= 3000) ? "DEUDA_MEDIA" : "DEUDA_BAJA";

        return cliente.getSegmento() + "_" + cliente.getRegion() + "_" + nivelIngreso + "_" + nivelScore + "_" + nivelDeuda;
    }
}