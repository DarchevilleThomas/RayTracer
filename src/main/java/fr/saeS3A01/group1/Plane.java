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

    /**
     *  Getter for point
     * @return Point
     */
    public Point getPoint() {
        return point;
    }

    /**
     *  Setter for point
     * @param point a Point
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     *  Getter for vector
     * @return Vector
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Setter for vector
     * @param vector a Vector
     */
    public void setVector(Vector vector) {
        this.vector = vector;
    }
}
