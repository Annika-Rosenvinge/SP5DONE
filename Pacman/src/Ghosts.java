import processing.core.PApplet;
import processing.core.PVector;

//Author: Annika

class Ghost extends PApplet {
    PVector pos;
    int chaseCounter = 0;
    boolean chase;
    boolean scatter;
    int x;
    int y;
    int maxX;
    int maxY;
    //int millis = millis();

    public Ghost(PVector pos) {
        this.pos = pos;


    }

    public void chasePacman(){
        chaseCounter ++;
        if (chase){
            if (chaseCounter > 0){
                chase = true;
            }
            else {
                if (chaseCounter > 3000){
                    chase = false;
                }
            }
        }
        if (chase == false){
            chaseCounter = 0;
        }

    }
    public void moveLeft() {
        --x;
        if(x < 0) {
            x = 0;
        }
    }

    public void moveRight() {
        ++x;
        if(x > maxX) {
            x = maxX;
        }
    }

    public void moveUp() {
        --y;
        if(y < 0) {
            y = 0;
        }
    }

    public void moveDown() {
        ++y;
        if(y > maxY) {
            y = maxY;
        }
    }

}

