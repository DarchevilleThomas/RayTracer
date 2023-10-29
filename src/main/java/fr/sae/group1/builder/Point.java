package fr.sae.group1.builder;

public class Point {
    private Triplet triplet;

    /**
     * Constructor with variables x,y,z
     *
     * @param x a double
     * @param y a double
     * @param z a double
     */
    public Point(double x, double y, double z){
        this.triplet=new Triplet(x,y,z);
    }

    /**
     * Constructor with a triplet
     *
     * @param t a triplet
     */
    public Point(Triplet t){
        this.triplet = t;
    }

    /**
     * Subtraction of 2 points returning a vector
     *
     * @param p (Point)
     * @return Vector
     */
    public Vector sub(Point p) {
        if (p==null || this.triplet==null) throw new IllegalArgumentException("Cannot subtract an empty triple");
        return new Vector(this.triplet.sub(p.getTriplet()));
    }

    /**
     * Multiplication by a scalar of a point
     *
     * @param d a double
     * @return a point
     */
    public Point mul(double d) {
        if (this.triplet==null) throw new IllegalArgumentException("Cannot multiply a null triple by a scalar product");
        return new Point(this.triplet.mul(d));
    }

    /**
     * Get the triplet of the point
     *
     * @return a point
     */
    public Triplet getTriplet() {
        return triplet;
    }

    /**
     * Change the triplet of the current point
     *
     * @param triplet a triplet
     */
    public void setTriplet(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Calculates the Euclidean distance from this point to another point.
     *
     * @param other the other point
     * @return the Euclidean distance from this point to the other point
     */
    public double distance(Point other) {
        double dx = other.triplet.getX() - this.triplet.getX();
        double dy = other.triplet.getY() - this.triplet.getY();
        double dz = other.triplet.getZ() - this.triplet.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Returns a string representation of this Point.
     * 
     * @return A string representation of this Point.
     */
    @Override
    public String toString() {
        return "Point {x=" + triplet.getX() + ", y=" + triplet.getY() + ", z=" + triplet.getZ() + "}";
    }
}
