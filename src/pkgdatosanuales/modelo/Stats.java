package pkgdatosanuales.modelo;

import java.time.LocalDate;
import java.util.*;

/**
 * !!!!!!!!!!!!!!!!!!!!!!!!
 * @author      NOMBRE
 * !!!!!!!!!!!!!!!!!!!!!!!!
 */
public class Stats {

    /**
     * Los valores recogidos para distintas fechas.
     * Asocia a una fecha (la clave) con el valor entero recogido.
     */
    private HashMap<LocalDate, Integer> datosFechas;

    public void setDatosFechas(HashMap<LocalDate, Integer> datosFechas) {
        this.datosFechas = datosFechas;
    }

    /**
     * Devuelve una colección en la que la clave se corresponde con el valor numérico del mes,
     * es decir, enero (1), febrero (2), etc. Los valores asociados a cada clave son un ArrayList
     * con los valores recogidos en cada día del mes. Por ejemplo, si el 1 de febrero hubo 36 dl/m²
     * y el 28 de febrero 15 dl/m² el ArrayList asociado al mes de febrero tendrá un tamaño de 28
     * y en su posición 0 tendrá el valor 36 y en la posición 27 el valor 15. <br/>
     * Considera que cuando se vaya a registrar un valor asociado a un día de un mes,
     * primero se debe comprobar si la clave del mes ya existe, si no existe se debe crear un ArrayList
     * al que agregar el primer valor en la posición correspondiente, para lo cual se debe inicializar
     * antes a cero todos los días del mes (initArrayList). <br/>
     * Si no es el primer valor que se recoge asociado a un mes, se debe fijar ese valor en la posición
     * correspondiente en el ArrayList (considera el ejemplo de febrero al inicio de este apartado). <br/>
     * @return colección TreeMap
     */
    private TreeMap<Integer, ArrayList<Integer>> datosMeses() {
        TreeMap<Integer, ArrayList<Integer>> datosMeses = new TreeMap<>();
        for (Map.Entry<LocalDate, Integer> entrada : datosFechas.entrySet()) {
            LocalDate fechaLocal = entrada.getKey();
            int mes = fechaLocal.getMonthValue();
            int dia = fechaLocal.getDayOfMonth();
            int valor = entrada.getValue();

            if (!datosMeses.containsKey(mes)){
                ArrayList<Integer> datos = initArrayList(fechaLocal.lengthOfMonth());
                datos.set(dia-1, valor);
                datosMeses.put(mes, datos);
            }else{
                ArrayList<Integer> datos = datosMeses.get(mes);
                datos.set(dia-1, valor);
            }
        }
        return datosMeses;
    }

    /**
     * Devuelve una nueva instancia de ArrayList de tamaño pasado como parámetro tam en la que
     * todas las posiciones tienen el valor cero.
     * @param tam tamaño del array list
     * @return ArrayList<Integer> de tamaño tam inicializado a ceros.
     */
    private static ArrayList<Integer> initArrayList(int tam) {
        return new ArrayList<>(Arrays.asList(new Integer[tam]));
//        ArrayList<Integer> arrayList = new ArrayList<>(tam);
//        for (int i = 0; i < tam; i++) {
//            arrayList.add(0);
//        }
//        return arrayList;
    }

    /**
     * Devuelve un string con la representación que se puede ver en el resultado. Se reservan
     * doce caracteres para mostrar el nombre del mes en mayúsculas alineado a la derecha y
     * a continuación el valor asociado a cada día del mes en cuatro caracteres. De esta forma
     * los valores quedan alineados y aparecen huecos al final de las líneas según los días de cada mes.
     * @return tabla de valores en la que cada fila representa a un mes ORDENADO.
     */
    public String getDatosMeses() {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, ArrayList<Integer>> datosMeses = datosMeses();
        for (Map.Entry<Integer, ArrayList<Integer>> entrada : datosMeses.entrySet()) {
            int mes = entrada.getKey();
            sb.append(String.format("%12s", nombreNumeroMes(mes)));
            ArrayList<Integer> valores = entrada.getValue();
            for (int i = 0; i < valores.size(); i++) {
                sb.append(String.format("%4d", valores.get(i)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Devuelve el nombre del mes asociado al número pasado como parámetro mes al método.
     * Por ejemplo, 1 es ENERO, 12 DICIEMBRE. Se debe utilizar el enum Mes (una línea de código)
     * o LocalDate en su defecto (un poco más largo). Si se utiliza una solución distinta al Enum
     * o LocalDate no se puntuará el apartado.
     * @param mes p.ej. 1
     * @return p.ej. ENERO
     */
    private static String nombreNumeroMes(int mes) {
//        LocalDate ld = LocalDate.of(2021,mes,1);
//        return ld.format(DateTimeFormatter.ofPattern("MMMM", new Locale("es","ES"))).toUpperCase();
        return Mes.values()[mes-1].toString();
    }

    /**
     * Cuenta cuantos valores son mayores que cero.
     * @param valores lista de valores
     * @return de 0 al tamaño de la lista
     */
    private int cuentaValores(List<Integer> valores) {
        int sum = 0;
        for (Integer valor : valores) {
            if (valor > 0) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * Devuelve un mapa con los nombres de los meses de enero a diciembre en mayúsculas ordenados
     * junto con el valor que indica cuántos días ha llovido algo. Se puede utilizar el método datosMeses
     * y el método nombreNumeroMes junto con el método cuentaValores para poder agregar el valor
     * correspondiente a cada mes a la colección que se devuelve de tipo LinkedHashMap.
     * @return p.ej. <br/>
     *  ENERO FEBRERO MARZO ABRIL MAYO JUNIO JULIO AGOSTO SEPTIEMBRE OCTUBRE NOVIEMBRE DICIEMBRE <br/>
     *   15      10     8    10    14    13    4      2       13        5       15         13    <br/>
     */
    private LinkedHashMap<String, Integer> cuentaValoresMeses() {
        LinkedHashMap<String, Integer> mediaValoresMeses = new LinkedHashMap<>();

        TreeMap<Integer, ArrayList<Integer>> datosMeses = datosMeses();
        for (Map.Entry<Integer, ArrayList<Integer>> entrada : datosMeses.entrySet()) {
            int mes = entrada.getKey();
            String nombreMes = nombreNumeroMes(mes);
            ArrayList<Integer> valores = entrada.getValue();
            int v = cuentaValores(valores);
            mediaValoresMeses.put(nombreMes, v);
        }

        return mediaValoresMeses;
    }

    /**
     * Devuelve un string con dos filas en la que la primera contiene las tres primeras letras del nombre
     * del mes en mayúsculas y la segunda, el número de días del mes que el valor ha sido mayor que cero.
     * Las cifras se deben alinear con los meses (un hueco y 3 caracteres para el nombre o la cifra).
     * @return p.ej. <br/>
     *  ENE FEB MAR ABR MAY JUN JUL AGO SEP OCT NOV DIC <br/>
     *   15  10   8  10  14  13   4   2  13   5  15  13 <br/>
     */
    public String getCuentaValoresMeses() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, Integer> cuentaValoresMeses = cuentaValoresMeses();
        for (String s : cuentaValoresMeses.keySet()) {
            sb.append(" ").append(s.substring(0,3));
        }
        sb.append("\n");
        for (Integer valor : cuentaValoresMeses.values()) {
            sb.append(String.format("%4d", valor));
        }
        sb.append("\n");
        return sb.toString();
    }

}
