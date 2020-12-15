import processing.core.PImage;
import processing.core.PVector;

import java.nio.file.Path;
import java.util.ArrayList;

//Author: Annika og Maria

public class Blinky extends Ghost {

    Pacman pacman;
    PVector vel = new PVector(1,0);
    Path path;
    Tile[][] tiles;
    Node node;
    ArrayList<Node> blinkyPath = new ArrayList<Node>();
    Node pathStart;
    Node pathEnd;
    public Blinky(PVector pos) {
        super(pos);
        setPath();

    }

    public static PVector pos(){
        PVector pos = new PVector(13*16 +8, 11*16+8);
        return pos;
    }

    public void setPath(){
        blinkyPath.clear();
        setNodes();
        pathStart = blinkyPath.get(0);
        pathEnd = blinkyPath.get(blinkyPath.size()-1);
    }

    public void setNodes(){
        float newXpos = (pos.x - 8)/16;
        float newYpos = (pos.y - 8)/16;
        blinkyPath.add(new Node(newXpos,newYpos));
        for (int i = 1; i< 27; i++) {
            for (int j = 1; j < 30; j++) {
                if (!tiles[j][i].wall) {
                    if (!tiles[j - 1][i].wall || !tiles[j + 1][i].wall) {
                        if (!tiles[j][i - 1].wall || !tiles[j][i + 1].wall) {
                        }
                    }
                }
            }
        }
    }

    void move(){
        float xDirection = pos.x - pacman.getXdirection();
        float yDirection = pos.y - pacman.getYdirection();

        for (int i = 1; i < 27; i++) {
            for (int j = 1; j < 30; j++) {
                if (xDirection > 0 && !tiles[j][i + 1].wall){
                    moveRight();
                }
                else if (xDirection > 0 && tiles[j][i - 1].wall){
                    moveLeft();
                }
                else if (yDirection > 0 && !tiles[j - 1][i].wall){
                    moveUp();
                }
                else if (yDirection > 0 && tiles[j + 1][i].wall){
                    moveDown();
                }

            }
        }


    }

    void show(){
        fill(239,45,45);
        stroke(239,45,45);
        ellipse(3, 3, 13*16+8, 11*16+8);
        PImage blinkyImg = loadImage("Ghost_Blinky.jpg");
        color (239,45,45);
    }


}