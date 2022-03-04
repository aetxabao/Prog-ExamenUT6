package pkgdatosanuales.io;

import pkgdatosanuales.modelo.Stats;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * !!!!!!!!!!!!!!!!!!!!!!!!
 * @author      NOMBRE
 * !!!!!!!!!!!!!!!!!!!!!!!!
 */
public class Reader {

    public static void loadData(String tipo, Stats stats) {
        HashMap<LocalDate, Integer> datosFechas = new HashMap<>();
        try (Scanner sc = new Scanner(Reader.class.getResourceAsStream("/" + tipo + ".csv"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(":");
                LocalDate fechaLocal = getFechaLocal(datos[0]);
                int valor = getEnteroValor(datos[1]);
                registrarValor(datosFechas, fechaLocal, valor);
            }
        }
        stats.setDatosFechas(datosFechas);
    }

    /**
     * Transforma un string con formato “dd-MM-yyyy” a una fecha local. Se puede parsear el string en
     * una sola línea con la clase LocalDate utilizando DateTimeFormatter con el patrón indicado.
     * @param fecha p.ej. 28-02-2021
     * @return LocalDate
     */
    private static LocalDate getFechaLocal(String fecha) {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    /**
     * Parsea el string a un entero. Una línea de código.
     * @param valor string
     * @return entero
     */
    private static int getEnteroValor(String valor) {
        return Integer.parseInt(valor);
    }

    /**
     * Incorpora al mapa el par clave-valor pasado como parámetro.  Una línea de código.
     * @param datosFechas
     * @param fechaLocal
     * @param valor
     */
    private static void registrarValor(HashMap<LocalDate, Integer> datosFechas, LocalDate fechaLocal, int valor) {
        datosFechas.put(fechaLocal, valor);
    }

}
