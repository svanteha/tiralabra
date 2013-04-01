
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
    private Node[][] nodeKartta;
    private int korkeus;
    private int leveys;
    private int algoritmi; //1 = A*, 2 = Dijkstra

    
    public Logiikka(int korkeus, int leveys, int algoritmi) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.algoritmi = algoritmi;
        this.mapGenerator = new MapGenerator(this.korkeus, this.leveys);
        this.kartta = mapGenerator.generateMap();
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
                //System.out.println("reitti: " + nodeKartta[nodeKartta.length-1][nodeKartta[0].length-1].getReitti());
                break;
            }
            
            checkUp(thisY, thisX, node, keko);
            checkDown(thisY, thisX, node, keko);
            checkLeft(thisY, thisX, node, keko);
            checkRight(thisY, thisX, node, keko);
            
            if (keko.isEmpty()) {
                System.out.println("EI LÖYTYNYT!");
                break;
            }
        }
        
    }
    
    public void tulostaKartta(){
        mapGenerator.printMap(kartta);
    }

    private Node[][] luoNodeKartta(char[][] kartta) {
        Node[][] nodeKartta = new Node[kartta.length][kartta[0].length];
        
        for (int i = 0; i < kartta.length; i++) {
            for (int j = 0; j < kartta[0].length; j++) {
                Node node = new Node(i, j, kartta.length - 1, kartta[0].length - 1);
                nodeKartta[i][j] = node;
                if (i == 0 & j == 0) {
                    node.setValue(0);
                }
            }
            
        }
        return nodeKartta;
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
