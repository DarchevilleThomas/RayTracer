package fr.saeS3A01.group1;

public class Color {

    private Triplet triplet;

    private double red, green, blue;
    public Color(double red, double green, double blue,double x, double y, double z){
        triplet = new Triplet(x,y,z);
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public Color(double x, double y, double z){
        this(x,y,z,0.0,0.0,0.0);
    }

    public Triplet add(double red, double green, double blue){
        return triplet.add(new Triplet(red,green,blue));
    }

    public Triplet mul(double d){
        return triplet.mul(d);
    }
}
