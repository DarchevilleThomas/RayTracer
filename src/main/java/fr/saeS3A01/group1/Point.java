package fr.saeS3A01.group1;

public class Point {
    private Triplet triplet;

    public Point(double x, double y, double z){
        this.triplet=new Triplet(x,y,z);
    }

    public Point(Triplet t){
        this.triplet = t;
    }

    public Vector substract(Point p) throws Exception {
        if (p==null || this.triplet==null) throw new Exception("Impossible de soustraire un triplet vide");
        return new Vector(this.triplet.sub(p.getTriplet()));
    }



}
