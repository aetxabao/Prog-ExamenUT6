package pkgdatosanuales.test;

import pkgdatosanuales.io.Reader;
import pkgdatosanuales.modelo.Stats;

public class TestDatosAnuales {

    public static void main(String[] args) {

        Stats stats = new Stats();

        Reader.loadData("lluvia", stats);

        System.out.println("=".repeat(140));

        System.out.print(stats.getDatosMeses());

        System.out.println("=".repeat(140));

        System.out.print(stats.getCuentaValoresMeses());

        System.out.println("=".repeat(140));

    }

}
