
import processing.core.PImage;
import processing.core.PVector;

import java.nio.file.Path;
import java.util.ArrayList;

//Author: Annika

public class Inky extends Ghost{

    PVector vel = new PVector(1,0);
    Path path;
    Tile[][] tiles;
    Node node;
    ArrayList <Node> inkyPath = new ArrayList<Node>();
    Node pathStart;
    Node pathEnd;
    Pacman pacman;

    public Inky(PVector pos) {
        super(pos);
        setPath();
    }

    public static PVector pos(){
        PVector pos = new PVector(8*16 +8, 1*16+8);
        return pos;
    }

    private void setPath() {
        inkyPath.clear();
        setNodes();
        pathStart = inkyPath.get(0);
        pathEnd = inkyPath.get(inkyPath.size()-1);

    }


    private void setNodes() {
        float newXpos = (pos.x-8)/16;
        float newYpos = (pos.y-8)/16;
        inkyPath.add(new Node(newXpos,newYpos));

        for (int i = 1; i < 27; i++){
            for (int j = 1; j < 30; j++){
                if (!tiles[j][i].wall){
                    //Ser om den kan komme op eller ned
                    if (!tiles[j-1][i].wall || !tiles[j+1][i].wall) {
                        //Ser om den kan komme til venstre eller højre
                        if (!tiles[j][i - 1].wall || !tiles[j][i + 1].wall) {
                            inkyPath.add(new Node(i,j));
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
        fill(135,206,250);
        stroke(135,206,250);
        ellipse(3, 3, 8*16+8, 1*16+8);
        PImage inkyImg = loadImage("Ghost_Inky.jpg");
        color (135,206,250);
    }


}
