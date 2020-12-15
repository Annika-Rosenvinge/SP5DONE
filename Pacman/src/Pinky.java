import processing.core.PImage;
import processing.core.PVector;

import java.nio.file.Path;
import java.util.ArrayList;

//Author: Annika

public class Pinky extends Ghost{
    PVector vel = new PVector(1,0);
    Path path;
    Tile[][] tiles;

    Node node;
    ArrayList<Node> pinkyPath = new ArrayList<Node>();
    Node pathStart;
    Node pathEnd;

    public Pinky(PVector pos) {
        super(pos);
        setPath();
    }

    public static PVector pos(){
        PVector pos = new PVector(23*16 +8, 26*16+8);
        return pos;
    }

    public void setPath(){

        setNodes();
        pinkyPath.clear();
        pathStart = pinkyPath.get(0);
        pathEnd = pinkyPath.get(pinkyPath.size()-1);
    }

    public void setNodes(){
        float newXpos = (pos.x-8)/16;
        float newYpos = (pos.y-8)/16;
        pinkyPath.add(new Node(newXpos,newYpos));

        for (int i = 1; i< 27; i++) {//check every position
            for (int j = 1; j < 30; j++) {
                if (!tiles[j][i].wall) {
                    if (!tiles[j - 1][i].wall || !tiles[j + 1][i].wall) {
                        if (!tiles[j][i - 1].wall || !tiles[j][i + 1].wall) {

                            pinkyPath.add(new Node(i, j));
                        }
                    }
                }
            }
        }

    }

    void move(){
        int move = (int) random(4);
        for (int i = 1; i < 27; i++) {
            for (int j = 1; j < 30; j++) {
                if (move==0 && !tiles[j][i + 1].wall){
                    moveRight();
                }
                else if(move == 1 && !tiles[j][i - 1].wall){
                    moveLeft();
                }
                else if (move == 2 &&!tiles[j - 1][i].wall){
                    moveUp();
                }
                else if (move == 3 && tiles[j + 1][i].wall){
                    moveDown();
                }

            }
        }


    }

    public void show(){
        fill(255,91,255);
        stroke(255,91,255);
        ellipse(3, 3, 23*16+8, 26*16+8);
        PImage inkyImg = loadImage("resources\\Ghost_Pinky.jpg");
        color (255,91,255);
    }

}
