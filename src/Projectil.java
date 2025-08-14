import processing.core.PApplet;
import processing.core.PImage;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class Projectil {
    float x0, y0;
    float x, y;
    float f, a;
    float v0x, v0y, vy;
    float r = 10;

    PImage imgCano;

    void setImatgeCano(PApplet p5){
        this.imgCano = p5.loadImage("cannon.png");
    }

    Projectil(float x, float h, float f) {

        this.x0 = x;
        this.y0 = h;

        this.x = x;
        this.y = h;

        this.f = f;
        this.a = 0;

        this.v0x = +f * cos(this.a);
        this.v0y = -f * sin(this.a);
        this.vy = this.v0y;
    }

    void display(PApplet p5){
        float dx = this.x0 + this.f *cos(this.a);
        float dy = this.y0 - this.f *sin(this.a);

        p5.pushStyle();

        // Projectil
        p5.noStroke(); p5.fill(255, 0, 0);
        p5.circle(this.x, this.y, 2*this.r);

        // Tub del canó
        p5.strokeWeight(15); p5.stroke(255, 0, 0);
        p5.line(this.x0, this.y0, dx, dy);

        // Cos del canó
        p5.imageMode(p5.CENTER);
        p5.pushMatrix();
        p5.translate(this.x0, this.y0);
        p5.scale(0.15f, 0.15f);
        p5.rotate( -this.a);
        p5.image(this.imgCano, 0, 210);
        p5.popMatrix();


        p5.fill(0); p5.textSize(14); p5.textAlign(p5.LEFT);
        p5.text("Sx:"+ p5.nf(this.x,3,2)+", Sy: "+ p5.nf(this.y,3,2),55,80);
        p5.text("Vx:"+ p5.nf(this.v0x,2,2)+",Vy:"+ p5.nf(this.vy,2,2),55,100);
        p5.text("F: " + p5.nf(this.f, 2, 2), 55, 120);

        p5.popStyle();

    }

    void setProperties(float a, float f, float h){

        this.y = h;
        this.y0 = h;

        this.a = a;
        this.f = f;

        this.v0x = + this.f * cos(this.a);
        this.v0y = - this.f * sin(this.a);
        this.vy = this.v0y;
    }

    void update(float t, float g){

        this.x = this.x0 + this.v0x * t;
        this.y = this.y0 + this.vy*t - 0.5f*g*t*t;

        this.vy = this.v0y + g*t;
    }




}
