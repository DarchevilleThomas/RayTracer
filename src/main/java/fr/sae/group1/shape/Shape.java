package fr.sae.group1.shape;

import fr.sae.group1.builder.Checker;
import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;

public abstract class Shape {

    private Color diffuse;
    private Color specular;
    private int shininess;
    private Checker checker;

    /**
     *  Constructor of the Figure class
     * @param diffuse a Color
     * @param specular a Color
     * @param shininess a int
     */
    protected Shape(Color diffuse, Color specular, int shininess, Checker checker){
        this.diffuse=diffuse;
        this.specular=specular;
        this.shininess=shininess;
        this.checker=checker;
    }

    /**
     * Return the checker of a shape (useless when the shape is not a plane)
     *
     * @return checker
     */
    public Checker getChecker() {
        return checker;
    }

    /**
     * Set the checker of a shape (useless when the shape is not a plane)
     *
     * @param checker a checker
     */
    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    /**
     *  getter for diffuse
     * @return Color
     */
    public Color getDiffuse() {
        return diffuse;
    }

    /**
     *  getter for specular
     * @return Color
     */
    public Color getSpecular() {
        return specular;
    }

    /**
     *  getter for shininess
     * @return int
     */
    public int getShininess() {
        return shininess;
    }

    /**
     *  setter for diffuse
     * @param diffuse a Color
     */
    public void setDiffuse(Color diffuse) {
        this.diffuse = diffuse;
    }

    /**
     *  setter for shininess
     * @param shininess a int
     */
    public void setShininess(int shininess) {
        this.shininess = shininess;
    }

    /**
     *  Setter for specular
     * @param specular a Color
     */
    public void setSpecular(Color specular) {
        this.specular = specular;
    }

    /**
     * Abstract method distance.
     * @param lookFrom a Point
     * @param d a Vector
     * @return double
     * @throws AbstractMethodError throw Exception
     */
    public abstract double distance(Point lookFrom, Vector d) throws AbstractMethodError;

    /**
     * Method to get the normal of a shape
     * @param p a Point
     * @return a vector
     * @throws AbstractMethodError throw Exception
     */
    public abstract Vector getN(Point p) throws AbstractMethodError;

    /**
     * Calculates the point of intersection between a straight line and a sphere.
     *
     * @param point The origin of the line.
     * @param d The direction vector of the line.
     * @return The point of intersection between the line and the sphere, or null if there is no intersection.
     */
    public abstract Point intersection(Point point, Vector d);
}
