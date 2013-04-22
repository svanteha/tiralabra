
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class MapGenerator {
    
    private int korkeus;
    private int leveys;
    private Random random;
    private Scanner scanner;
    
    public MapGenerator (int korkeus, int leveys) {
        this.random = new Random();
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.scanner = new Scanner(System.in);
    }
    
    public char[][] manualMapGeneration() {
        
        char[][] kartta = new char[korkeus][leveys];
        
        System.out.println("Kirjoita kartta: tyhjä vastaa tyhjää, kaikki muut luetaan seiniksi");
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta.length; j++) {
                String syote = scanner.nextLine();
                if (syote.length() == 0) {
                    kartta[i][j] = '.';
                }
                else {
                    kartta[i][j] = '#';
                }
                printMap(kartta);
            }

        }
        
        kartta[0][0] = '*';
        kartta[korkeus-1][leveys-1] = '*';
        
        return kartta;
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
        
        //seinät, aluksi kokeillaan 30% seiniä
        double laskuri = (korkeus * leveys) * (10 * 0.01);
        
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
