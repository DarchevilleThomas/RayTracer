package fr.saeS3A01.group1;

public class Color {

    private Triplet triplet;

    private double red, green, blue;
    public Color(double red, double green, double blue){
        triplet = new Triplet(red,green,blue);
    }

    public Color(Triplet triplet){
        this(triplet.x, triplet.y, triplet.z);
    }


    public Color add(double red, double green, double blue){
        return new Color(triplet.add(new Triplet(red,green,blue));
    }

    public Color mul(double d){
        return new Color(triplet.mul(d));
    }


}
