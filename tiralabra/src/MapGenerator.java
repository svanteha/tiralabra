
import java.util.Random;


public class MapGenerator {
    
    private int korkeus;
    private int leveys;
    private Random random;
    
    public MapGenerator (int korkeus, int leveys) {
        this.random = new Random();
        this.korkeus = korkeus;
        this.leveys = leveys;
    }
    
    public char[][] generateMap() {
        
        char[][] kartta = new char[korkeus][leveys];
        
        //kartan pohja
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                
                kartta[i][j] = '.';
                
            }            
        }
        //lähtöpaikka
        kartta[0][0] = '*';
        
        //maali
        kartta[korkeus-1][leveys-1] = '*';
        
        //tyhjät paikat, aluksi kokeillaan 30% tyhjää
        double laskuri = (korkeus * leveys) * (30 * 0.01);
        
        while (laskuri > 0) {
            
            int k = random.nextInt(korkeus);
            int l = random.nextInt(leveys);
            
            if ((k != 0 || l != 0) && (k != kartta.length-1 || l != kartta[0].length-1)) {
                kartta[k][l] = '#';
            }
            laskuri--;
        }
        return kartta;
    }
    
    public void printMap(char[][] kartta) {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                
                System.out.print(kartta[i][j]);
                
            }
            System.out.println("");
        }
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }
    
    
}
