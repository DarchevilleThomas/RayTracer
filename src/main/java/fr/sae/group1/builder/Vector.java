package fr.sae.group1.builder;

/**
 * Class Vector to create a vector using a triplet
 */
public class Vector {

    private Triplet triplet; //We declare a private Triplet attribute triplet.

    /**
     * Constructor of a vector with three points x,y,z.
     * @param x a double
     * @param y a double
     * @param z a double
     */
    public Vector(double x,double y,double z){
        this.triplet = new Triplet(x,y,z);
    }

    /**
     * Constructor of a vector with a Triplet t.
     * @param t a Triplet
     */
    public Vector(Triplet t){
        this.triplet = t;
    }

    /**
     * We add two vectors.
     * @param v a Vector
     * @return a vector.
     */
    public Vector add(Vector v){
        return new Vector(this.triplet.add(v.getTriplet()));
    }

    /**
     * Adding a vector to a point gives a point.
     * @param p a Point
     * @return a point.
     */
    public Point add(Point p){
        return new Point(this.triplet.add(p.getTriplet()));
    }

    /**
     * We substract two vectors.
     * @param v a Vector
     * @return a vector.
     */
    public Vector sub(Vector v){
        return new Vector(this.triplet.sub(v.getTriplet()));
    }

    /**
     * We multiply by a scalar.
     * @param d a double.
     * @return a vector.
     */
    public Vector mul(double d){
        return new Vector(this.triplet.mul(d));
    }

    /**
     * We calculate the scalar product by another vector.
     * @param v a Vector.
     * @return a double.
     */
    public double dot(Vector v){
        return this.triplet.dot(v.getTriplet());
    }

    /**
     * We calculate the vector product by another vector.
     * @param v a Vector.
     * @return a vector.
     */
    public Vector cross(Vector v){
        return new Vector(this.triplet.cross(v.getTriplet()));
    }

    /**
     * We calculate the length of a vector.
     * @return a double.
     */
    public double length(){
        return this.triplet.length();
    }

    /**
     * We normalize the vector.
     * @return a vector.
     */
    public Vector normalize(){
        return new Vector(this.triplet.normalize());
    }

    /**
     * Method for recovering the triple.
     * @return a Triplet
     */
    public Triplet getTriplet() {

        return triplet;
    }

    /**
     * Returns a string representation of this Vector.
     * 
     * @return A string representation of this Vector.
     */
    @Override
    public String toString() {
        return "Vector {x=" + triplet.getX() + ", y=" + triplet.getY() + ", z=" + triplet.getZ() + "}";
    }
}
