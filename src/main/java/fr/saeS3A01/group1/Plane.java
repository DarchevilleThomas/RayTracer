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

    /**
     * Method to calculate the distance for a plane
     * @param lookFrom
     * @param d
     * @return a double
     * @throws Exception
     */
    @Override
    public double distance(Point lookFrom, Vector d) throws Exception {
        if(d.dot(vector)<0.0001){
            return -1;
        }
        double t =((point.sub(lookFrom)).dot(vector))/d.dot(vector);
        return t;
    }

    /**
     * Method to get the normale of a plane.
     * @param p
     * @return a vector
     * @throws Exception
     */
    @Override
    public Vector getN(Point p) throws Exception {

        return this.vector;
    }

    /**
     * Returns a string representation of this Plane.
     * The string representation is "Plane {point=POINT, vector=VECTOR}", where POINT
     * and VECTOR are the point and vector of this Plane.
     * 
     * @return A string representation of this Plane.
     */
    @Override
    public String toString() {
        return "Plane {point=" + point + ", vector=" + vector + "}";
    }
}