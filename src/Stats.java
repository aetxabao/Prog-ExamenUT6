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
        //TODO: datosMeses
        return null;
    }

    /**
     * Devuelve una nueva instancia de ArrayList de tamaño pasado como parámetro tam en la que
     * todas las posiciones tienen el valor cero.
     * @param tam tamaño del array list
     * @return ArrayList<Integer> de tamaño tam inicializado a ceros.
     */
    private static ArrayList<Integer> initArrayList(int tam) {
        //TODO: initArrayList
        return null;
    }

    /**
     * Devuelve un string con la representación que se puede ver en el resultado. Se reservan
     * doce caracteres para mostrar el nombre del mes en mayúsculas alineado a la derecha y
     * a continuación el valor asociado a cada día del mes en cuatro caracteres. De esta forma
     * los valores quedan alineados y aparecen huecos al final de las líneas según los días de cada mes.
     * @return tabla de valores en la que cada fila representa a un mes ORDENADO.
     */
    public String getDatosMeses() {
        //TODO: getDatosMeses
        return null;
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
        //TODO: nombreNumeroMes
        return null;
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
        //TODO: cuentaValoresMeses
        return null;
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
        //TODO: getCuentaValoresMeses
        return null;
    }

}
