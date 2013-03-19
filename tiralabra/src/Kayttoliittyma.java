/**
 *
 * @author svanteha
 */

import java.util.*;

public class Kayttoliittyma {
    
    private Scanner lukija = new Scanner(System.in);
    
    public void start() {
        ohje();
        lueInt();
        
    }
    
    private int lueInt() {
        try {
            return Integer.parseInt(lukija.nextLine());
        } catch (Exception e) {
            System.out.println("Syötä kokonaisluku!");
            return lueInt();
        }
    }
    
    private void ohje(){
        System.out.println("Kirjoita syöte!");
        System.out.println("1 - Käytä A*-reitinhakua");
        System.out.println("2 - Käytä Dijkstra-reitinhakua");
        System.out.println("3 - Tulosta ohje");
        System.out.println("Kaikki muut syötteet lopettaa ohjelman");
    }
    
    
    
    
}
