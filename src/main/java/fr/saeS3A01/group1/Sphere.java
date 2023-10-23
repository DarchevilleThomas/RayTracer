package fr.saeS3A01.group1;

public class Sphere extends Shape {

    private Color diffuse;
    private Color specular;
    private int shininess;
    private double radius;
    private Point p;

    /**
     * Constructor of a sphere
     * @param diffuse a color
     * @param specular a color
     * @param shininess a int
     * @param p a point
     * @param radius a double
     */
    public Sphere(Color diffuse, Color specular, int shininess,Point p,double radius) {
        super(diffuse, specular, shininess);
        this.p = p;
        this.radius = radius;
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(double radius) {

        this.radius = radius;
    }

    public Point getP() {

        return p;
    }

    public void setP(Point p) {

        this.p = p;
    }

}
