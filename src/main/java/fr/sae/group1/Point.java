package fr.sae.group1;

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
     * @throws Exception If the parameter p is null or the triplet is null, the method throws an exception
     */
    public Vector sub(Point p) throws Exception {
        if (p==null || this.triplet==null) throw new Exception("Cannot subtract an empty triple");
        return new Vector(this.triplet.sub(p.getTriplet()));
    }

    /**
     * Multiplication by a scalar of a point
     *
     * @param d a double
     * @return a point
     * @throws Exception If the triplet is null, the method throws an exception
     */
    public Point mul(double d) throws Exception {
        if (this.triplet==null) throw new Exception("Cannot multiply a null triple by a scalar product");
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
     * Returns a string representation of this Point.
     * 
     * @return A string representation of this Point.
     */
    @Override
    public String toString() {
        return "Point {x=" + triplet.x + ", y=" + triplet.y + ", z=" + triplet.z + "}";
    }
}
