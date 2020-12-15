
import processing.core.PImage;
import processing.core.PVector;

import java.nio.file.Path;
import java.util.ArrayList;

//Author: Annika og Maria

public class Clyde extends Ghost {
    boolean chase;
    boolean scatter;
    int millis = millis();
    int chaseCounter = 0;

    PVector vel = new PVector(1,0);
    Path path;
    ArrayList<Node> clydePath = new ArrayList<Node>();
    Node pathStart;
    Node pathEnd;
    Tile[][] tiles;


    public Clyde(PVector pos) {
        super(pos);
        setPath();
    }
    public static PVector pos(){
        PVector pos = new PVector(1*16 +8, 29*16+8);
        return pos;
    }

    private void setPath() {
        clydePath.clear();
        setNodes();
        pathStart = clydePath.get(0);
        pathEnd = clydePath.get(clydePath.size()-1);

    }

    private void setNodes() {
        float newXpos = (pos.x - 8) / 16;
        float newYpos = (pos.y - 8) / 16;
        clydePath.add(new Node(newXpos, newYpos));

        for (int i = 1; i < 27; i++) {
            for (int j = 1; j < 30; j++) {
                if (!tiles[j][i].wall) {
                    if (!tiles[j - 1][i].wall || !tiles[j + 1][i].wall) {
                        if (!tiles[j][i - 1].wall || !tiles[j][i + 1].wall) {
                            clydePath.add(new Node(i, j));
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

    void show(){
        fill(247,130,27);
        stroke(247,130,27);
        ellipse(3, 3, 1*16+8, 29*16+8);
        PImage clydeImg = loadImage("Ghost_Clyde.jpg");
        color (247,130,27);
    }


}


