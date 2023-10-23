package fr.saeS3A01.group1;

public class Vector {

    private Triplet triplet;
    private double x;
    private double y;
    private double z;

    public Vector(double x,double y,double z){
        this.triplet = new Triplet(x,y,z);
    }

    public Vector(Triplet t){
        this.triplet = t;
    }

    public Vector add(Triplet t){
        return new Vector(this.triplet.add(t));
    }

    public Vector sub(Triplet t){
        return new Vector(this.triplet.sub(t));
    }

    public Vector mul(double d){
        return new Vector(this.triplet.mul(d));
    }

    public double dot(Triplet t){
        return this.triplet.dot(t);
    }

    public Vector cross(Triplet t){
        return new Vector(this.triplet.cross(t));
    }

    public double length(){
        return this.triplet.length();
    }




}
