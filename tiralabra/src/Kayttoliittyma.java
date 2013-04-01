/**
 *
 * @author svanteha
 */

import java.util.*;

public class Kayttoliittyma {
    
    private Scanner lukija = new Scanner(System.in);
    private Logiikka logiikka;
    
    public void start() {
        
        logiikka = new Logiikka(kartanKorkeus(), kartanLeveys(), algoritmi());
        //logiikka.tulostaKartta();
        logiikka.haeReitti();
        
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
    
    
    
    
}
