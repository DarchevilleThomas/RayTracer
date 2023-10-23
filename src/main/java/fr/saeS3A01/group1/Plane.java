package fr.saeS3A01.group1;

public class Plane extends Shape {
    private Point point;
    private Vector vector;

    /**
     * Constructor of the Plane
     * @param diffuse a Color
     * @param specular a Color
     * @param shininess int
     * @param point a Point
     * @param vector  a Vector
     */
    public Plane(Color diffuse, Color specular, int shininess, Point point, Vector vector) {
        super(diffuse, specular, shininess);
        this.point = point;
        this.vector = vector;
    }


}
