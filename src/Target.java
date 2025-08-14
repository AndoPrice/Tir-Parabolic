import processing.core.PApplet;

public class Target {
    float x, y, r;
    enum ESTAT {PENDENT, EXPLOTAT, FALLAT};
    ESTAT estat;

    Target(float x, float y, float r){
        this.x = x;
        this.y = y;
        this.r = r;
        this.estat = ESTAT.PENDENT;
    }

    void setEstat(ESTAT e) {
        this.estat = e;
    }

    void display(PApplet p5){
        p5.pushStyle();
        p5.noStroke();
        if(estat == ESTAT.EXPLOTAT){
            p5.fill(255, 0, 0);
        }
        else if(estat == ESTAT.FALLAT){
            p5.fill(0, 0, 255);
        }
        else {
            p5.fill(0);
        }
        p5.circle(this.x, this.y, 2*this.r);
        p5.popStyle();
    }

    boolean esImpactatPer(PApplet p5, Projectil p){
        return (p5.dist(this.x, this.y, p.x, p.y) < p5.max(p.r,this.r));
    }







}
