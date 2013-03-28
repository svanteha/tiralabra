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
    private int lyhyinReitti;
    private String reitti;
    
    public Node(int y, int x, int kartanKorkeus, int kartanLeveys) {
        this.x = x;
        this.y = y;
        this.matkaMaaliin = (kartanKorkeus - y) + (kartanLeveys - x);
        this.lyhyinReitti = Integer.MAX_VALUE;
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
        return matkaMaaliin;
    }

    public void setMatkaMaaliin(int matkaMaaliin) {
        this.matkaMaaliin = matkaMaaliin;
    }

    public int getLyhyinReitti() {
        return lyhyinReitti;
    }

    public void setLyhyinReitti(int lyhyinReitti) {
        this.lyhyinReitti = lyhyinReitti;
    }

    public String getReitti() {
        return reitti;
    }

    public void setReitti(String reitti) {
        this.reitti = reitti;
    }
    
    
    
}
