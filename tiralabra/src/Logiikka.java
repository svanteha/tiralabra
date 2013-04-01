
import java.util.PriorityQueue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author svanteha
 */
public class Logiikka {
    
    private MapGenerator mapGenerator;
    private char[][] kartta;
    private int korkeus;
    private int leveys;
    private int algoritmi; //1 = A*, 2 = Dijkstra

    
    public Logiikka(int korkeus, int leveys, int algoritmi) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.algoritmi = algoritmi;
        this.mapGenerator = new MapGenerator(korkeus, leveys);
        this.kartta = mapGenerator.generateMap();
        
    }
    
    public void tulostaKartta(){
        mapGenerator.printMap(kartta);
    }
    
}
