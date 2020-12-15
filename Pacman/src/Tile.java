import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

//Author; Oliver

public class Tile extends PApplet {

    boolean wall = false;
    boolean dot = false;
    boolean bigDot = false;
    boolean eaten = false;
    PVector pos;
    PImage food;
    PImage powerUp;

    //constructor
    public Tile(float x, float y) {
        pos = new PVector(x, y);
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //draw a dot if there is one in this tile
    public void show() {
        if (dot) {
            if (!eaten) {//draw food
                food = loadImage ("resources\\pacManFood.jpg");
            }
        } else if (bigDot) {
            if (!eaten) {//draw big dot
                powerUp = loadImage("resources\\powerUp.jpg");
            }
        }

    }

}