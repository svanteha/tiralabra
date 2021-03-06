package tiralabra.logiikka;

import tiralabra.heap.MinHeap;
import tiralabra.heap.Node;


/**
 *
 * @author Svante Häggblom
 */
public class Logiikka {
    
    private MapGenerator mapGenerator;
    private char[][] kartta;
    private Node[][] nodeKartta;
    private int korkeus;
    private int leveys;
    private int algoritmi; //1 = A*, 2 = Dijkstra
    private boolean loytyi;
    private boolean omaKartta;
    private int seinienTod;

    
    public Logiikka(int korkeus, int leveys, int algoritmi, boolean omaKartta, int seinienTod) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.algoritmi = algoritmi;
        this.omaKartta = omaKartta;
        this.seinienTod = seinienTod;
        
    }
    
    public void alustaKartta() {
        if (omaKartta) {
            this.mapGenerator = new MapGenerator(this.korkeus, this.leveys);
            this.kartta = mapGenerator.manualMapGeneration();
        }
        else {
            this.mapGenerator = new MapGenerator(this.korkeus, this.leveys, seinienTod);
            this.kartta = mapGenerator.generateMap();
        }
        this.nodeKartta = luoNodeKartta(kartta);
    }
    
    public void haeReitti() {
        int koko = (kartta.length * kartta[0].length);
        Node node = nodeKartta[0][0];
        MinHeap keko = new MinHeap(koko);
        keko.insert(node);
        
        while (true) {
            node = keko.pop();
                        
            int thisY = node.getY();
            int thisX = node.getX();
            
            if (thisY == nodeKartta.length - 1 && thisX == nodeKartta[0].length - 1) {
                System.out.println("LÖYTYI!");
                loytyi = true;
                break;
            }
            
            checkUp(thisY, thisX, node, keko);
            checkDown(thisY, thisX, node, keko);
            checkLeft(thisY, thisX, node, keko);
            checkRight(thisY, thisX, node, keko);
            
            if (keko.isEmpty()) {
                System.out.println("EI LÖYTYNYT!");
                loytyi = false;
                break;
            }
        }
        
    }
    
    public void tulostaKartta(){
        mapGenerator.printMap(kartta);
    }
    
    public void tulostaReitti(){
        mapGenerator.printMap(reittiKartta());
    }
    
    public boolean onkoReittia() {
        return loytyi;
    }
    
    public char[][] reittiKartta() {
        
        char[][] reittiKartta = new char[kartta.length][kartta[0].length];
        Node maali = nodeKartta[nodeKartta.length - 1][nodeKartta[0].length - 1];
        String reitti = maali.getReitti();
        
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                
                reittiKartta[i][j] = kartta[i][j];
                
            }               
        }
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < reitti.length(); i++) {
            
            if (reitti.charAt(i) == 'U') {
                reittiKartta[y][x] = '*';
                y--;
            }
            if (reitti.charAt(i) == 'D') {
                reittiKartta[y][x] = '*';
                y++;
            }
            if (reitti.charAt(i) == 'L') {
                reittiKartta[y][x] = '*';
                x--;
            }
            if (reitti.charAt(i) == 'R') {
                reittiKartta[y][x] = '*';
                x++;
            }
            
        }
        reittiKartta[0][0] = '*';
        reittiKartta[y][x] = '*';
        return reittiKartta;
    }

    private Node[][] luoNodeKartta(char[][] kartta) {
        Node[][] nodeK = new Node[kartta.length][kartta[0].length];
        
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                Node node = new Node(i, j, kartta.length - 1, kartta[0].length - 1);
                nodeK[i][j] = node;
                if (i == 0 & j == 0) {
                    node.setValue(0);
                }
            }
            
        }
        return nodeK;
    }

    private void checkUp(int thisY, int thisX, Node node, MinHeap keko) {
        if (thisY > 0 && kartta[thisY - 1][thisX] != '#' && nodeKartta[thisY - 1][thisX].getValue() == Integer.MAX_VALUE) {
            Node up = nodeKartta[thisY - 1][thisX];
            up.setReitti(node.getReitti(), 'U');
            if(algoritmi == 1) {
                up.setValue(node.getValue() + 1 + up.getMatkaMaaliin());
            }
            else {
                up.setValue(node.getValue() + 1);
            }
            keko.insert(up);            
        }
    }

    private void checkDown(int thisY, int thisX, Node node, MinHeap keko) {
        if (thisY < kartta.length - 1 && kartta[thisY + 1][thisX] != '#' && nodeKartta[thisY + 1][thisX].getValue() == Integer.MAX_VALUE) {
            Node down = nodeKartta[thisY + 1][thisX];
            down.setReitti(node.getReitti(), 'D');
            if(algoritmi == 1) {
                down.setValue(node.getValue() + 1 + down.getMatkaMaaliin());
            }
            else {
                down.setValue(node.getValue() + 1);
            }
            keko.insert(down);            
        }
    }

    private void checkLeft(int thisY, int thisX, Node node, MinHeap keko) {
        if (thisX > 0 && kartta[thisY][thisX - 1] != '#' && nodeKartta[thisY][thisX - 1].getValue() == Integer.MAX_VALUE) {
            Node left = nodeKartta[thisY][thisX - 1];
            left.setReitti(node.getReitti(), 'L');
            if(algoritmi == 1) {
                left.setValue(node.getValue() + 1 + left.getMatkaMaaliin());
            }
            else {
                left.setValue(node.getValue() + 1);
            }
            keko.insert(left);            
        }
    }

    private void checkRight(int thisY, int thisX, Node node, MinHeap keko) {
        if (thisX < kartta[0].length - 1 && kartta[thisY][thisX + 1] != '#' && nodeKartta[thisY][thisX + 1].getValue() == Integer.MAX_VALUE) {
            Node right = nodeKartta[thisY][thisX + 1];
            right.setReitti(node.getReitti(), 'R');
            if(algoritmi == 1) {
                right.setValue(node.getValue() + 1 + right.getMatkaMaaliin());
            }
            else {
                right.setValue(node.getValue() + 1);
            }
            keko.insert(right);            
        }
    }
    
}
