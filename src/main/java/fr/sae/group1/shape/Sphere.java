package fr.sae.group1.shape;

import fr.sae.group1.builder.Checker;
import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;

/**
 * Sphere class to create a sphere (extends Shape interface)
 */
public class Sphere extends Shape {

    private double radius;
    private Point p;

    /**
     * Constructor of a sphere
     * @param diffuse a color
     * @param specular a color
     * @param shininess a int
     * @param p a point
     * @param radius a double
     * @param checker a checker
     */
    public Sphere(Color diffuse, Color specular, int shininess, Point p, double radius, Checker checker) {
        super(diffuse, specular, shininess,checker);
        this.p = p;

        this.radius = radius;
    }

    /**
     * Return the radius of a square
     *
     * @return the radius of a sphere
     */
    public double getRadius() {

        return radius;
    }

    /**
     * Set the radius of a sphere
     *
     * @param radius a double
     */
    public void setRadius(double radius) {

        this.radius = radius;
    }

    /**
     * Return the point of a sphere
     *
     * @return a point
     */
    public Point getP() {
        return p;
    }

    /**
     * Set the point of a sphere
     *
     * @param p a Point
     */
    public void setP(Point p) {
        this.p = p;
    }

    /**
     * A method to calculate the distance
     * @param lookFrom a Point
     * @param d a Vector
     * @return double
     */
    @Override
    public double distance(Point lookFrom, Vector d){
        double a = 1;
        double b = ((lookFrom.sub(p)).mul(2)).dot(d);
        double c = ((lookFrom.sub(p)).dot(lookFrom.sub(p))) - radius*radius;
        double delta = (b*b)-4*a*c;
        if(delta<0){
            return -1;
        }
        if(delta<0.001){
            return -b/2*a;
        }
        else {
            double t1 = (-b+Math.sqrt(delta))/2*a;
            double t2 = (-b-Math.sqrt(delta))/2*a;
            if(t2>0){
                return t2;
            }
            if(t1>0){
                return t1;
            }else{
                return -1;
            }
        }
    }

    /**
     * Calculates the point of intersection between a straight line and a sphere.
     *
     * @param point The origin of the line.
     * @param d The direction vector of the line.
     * @return The point of intersection between the line and the sphere, or null if there is no intersection.
     */
    public Point intersection(Point point, Vector d){
        // Calculer le point d'intersection
        double tmp = this.distance(point, d);
        if (tmp >= 0) {
            Vector td = d.mul(tmp); // Multiplier le vecteur direction par t
            return new Point(point.getTriplet().add(td.getTriplet())); // Ajouter ce vecteur au point
        } else return null;
    }

    /**
     * Method to get the normale of a sphere
     * @param p a Point
     * @return a vector
     */
    @Override
    public Vector getN(Point p) {

        return (p.sub(this.p)).normalize();
    }

    /**
     * Returns a string representation of this Sphere.
     *
     * @return A string representation of this Sphere.
     */
    @Override
    public String toString() {
        return "Sphere {point=" + p + ", radius=" + radius + "}";
    }
}
