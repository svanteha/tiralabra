
/**
 *
 * @author svanteha
 */
import java.util.*;

public class Kayttoliittyma {

    private Scanner lukija = new Scanner(System.in);
    private Logiikka logiikka;
    private boolean omaKartta;

    public void start() {

        logiikka = new Logiikka(kartanKorkeus(), kartanLeveys(), algoritmi(), omaKartta(), seinienTod());
        logiikka.alustaKartta();
//        logiikka.tulostaKartta();
        long start = System.nanoTime();
        logiikka.haeReitti();
        long end = System.nanoTime();
        long aika = end - start;
        double sekuntit = (double) aika / 1000000000.0;
        System.out.println("aikaa reitin löytämiseen kului " + sekuntit + " sekuntia");
        if (logiikka.onkoReittia()) {
            logiikka.tulostaReitti();
        }


    }

    private int seinienTod() {
        if (omaKartta) {
            return 0;
        }
        System.out.println("Kuinka suurella prosentilla seiniä?");
        return lueInt();
    }

    private int lueInt() {
        try {
            return Integer.parseInt(lukija.nextLine());
        } catch (Exception e) {
            System.out.println("Syötä kokonaisluku!");
            return lueInt();
        }
    }

    private int algoritmi() {
        System.out.println("Valitse algoritmi!");
        System.out.println("1: A*");
        System.out.println("2: Dijkstra");
        return lueInt();
    }

    private int kartanLeveys() {
        System.out.println("Anna kartan leveys");
        return lueInt();

    }

    private int kartanKorkeus() {
        System.out.println("Anna kartan korkeus");
        return lueInt();
    }

    private boolean omaKartta() {
        System.out.println("Haluatko kirjoittaa kartan käsin? y/kyllä");

        if (lukija.nextLine().equals("y")) {
            omaKartta = true;
            return true;
        }
        return false;
    }
}
