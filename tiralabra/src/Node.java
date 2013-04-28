/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author svanteha
 */
public class Node {
    
    private int x;
    private int y;
    private int matkaMaaliin;
    private int value;
    private String reitti;
    
    public Node(int y, int x, int kartanKorkeus, int kartanLeveys) {
        this.x = x;
        this.y = y;
        this.matkaMaaliin = (kartanKorkeus - y) + (kartanLeveys - x); //manhattan
        this.value = Integer.MAX_VALUE;
        this.reitti = "";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMatkaMaaliin() {
        return matkaMaaliin + reitti.length();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getReitti() {
        return reitti;
    }

    public void setReitti(String reitti, char suunta) {
        this.reitti = reitti + suunta;
    }
    
    
    
}
