package fr.sae.group1.shape;

import fr.sae.group1.builder.Checker;
import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;

/**
 * Triangle class to create a triangle (extends Shape interface)
 */
public class Triangle extends Shape{

    /**
     * first point of a triangle
     */
    protected Point point1;
    /**
     * second point of a triangle
     */
    protected Point point2;
    /**
     * third point of a triangle
     */
    protected Point point3;

    /**
     * Constructor of the Triangle class
     *
     * @param diffuse   a Color
     * @param specular  a Color
     * @param shininess a int
     * @param point1 a Point
     * @param point2 a Point
     * @param point3 a Point
     * @param checker a checker
     */
    public Triangle(Color diffuse, Color specular, int shininess, Point point1, Point point2, Point point3, Checker checker) {
        super(diffuse, specular, shininess, checker);
        this.point1=point1;
        this.point2=point2;
        this.point3=point3;
    }

    /**
     * Getter of the first point of the triangle
     *
     * @return first point of the triangle
     */
    public Point getPoint1() {
        return point1;
    }


    /**
     * Setter of the first point of the triangle
     *
     * @param point1 first point of the triangle
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    /**
     * Getter of the second point of the triangle
     *
     * @return second point of the triangle
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Setter of the second point of the triangle
     *
     * @param point2 second point of the triangle
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    /**
     * Getter of the third point of the triangle
     *
     * @return third point of the triangle
     */
    public Point getPoint3() {
        return point3;
    }

    /**
     * Setter of the third point of the triangle
     *
     * @param point3 third point of the triangle
     */
    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    /**
     * Method to calculate the distance of triangle
     * @param lookFrom a Point
     * @param d a Vector
     * @return double
     */
    @Override
    public double distance(Point lookFrom, Vector d) {
        Vector n = (point2.sub(point1)).cross((point3.sub(point1))).normalize();
        Plane plane = new Plane(this.getDiffuse(),this.getSpecular(),this.getShininess(),this.point1,n,this.getChecker());
        double t = plane.distance(lookFrom,d);
        Point p = (d.mul(t)).add(lookFrom);
        if(point2.sub(point1).cross((p.sub(point1))).dot(n)>=0
                && (point3.sub(point2).cross((p.sub(point2))).dot(n)>=0
                && ( point1.sub(point3).cross((p.sub(point3))).dot(n) >=0))){
            return t;


        }
        return -1;
    }

    /**
     * Method to get the normale of a triangle
     * @param p a Point
     * @return a vector
     */
    @Override
    public Vector getN(Point p)  {

        return ((point2.sub(point1)).cross((point3).sub(point1))).normalize();
    }

    /**
     * Returns a string representation of this Triangle.
     *
     * @return A string representation of this Triangle.
     */
    @Override
    public String toString() {
        return "Triangle {point1=" + point1 + ",point=2" + point2 + ",point3=" + point3 + "}";
    }

    @Override
    public Point intersection(Point point, Vector d) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Unimplemented method 'intersection'");
    }
}
