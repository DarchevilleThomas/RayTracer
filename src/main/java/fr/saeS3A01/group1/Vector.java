package fr.saeS3A01.group1;

public class Vector {

    private Triplet triplet; //We declare a private Triplet attribute triplet.
    private double x;  //We declare a private double attribute x.
    private double y;  //We declare a private double attribute y.
    private double z;  //We declare a private double attribute z.

    /**
     * Constructor of a vector with three points x,y,z.
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x,double y,double z){
        this.triplet = new Triplet(x,y,z);
    }

    /**
     * Constructor of a vector with a Triplet t.
     * @param t
     */
    public Vector(Triplet t){
        this.triplet = t;
    }

    /**
     * We add two vectors.
     * @param t
     * @return a vector.
     */
    public Vector add(Triplet t){
        return new Vector(this.triplet.add(t));
    }

    /**
     * We substract two vectors.
     * @param t
     * @return a vector.
     */
    public Vector sub(Triplet t){
        return new Vector(this.triplet.sub(t));
    }

    /**
     * We multiply by a scalar.
     * @param d
     * @return a vector.
     */
    public Vector mul(double d){
        return new Vector(this.triplet.mul(d));
    }

    /**
     * We calculate the scalar product by another triplet.
     * @param t
     * @return a double.
     */
    public double dot(Triplet t){
        return this.triplet.dot(t);
    }

    /**
     * We calculate the vector product by another triplet.
     * @param t
     * @return a vector.
     */
    public Vector cross(Triplet t){
        return new Vector(this.triplet.cross(t));
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


}
