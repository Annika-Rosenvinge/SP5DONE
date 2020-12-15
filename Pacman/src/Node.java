import com.sun.jdi.Type;
import processing.core.PApplet;

import java.util.ArrayList;


public class Node extends PApplet {
    final static int counter=0;
    int id;
    float xPos;
    float yPos;
    Type nodeType;
    Node parent;
    int col;

    Node(float x, float y) {
        xPos=x;
        yPos=y;
    }


}