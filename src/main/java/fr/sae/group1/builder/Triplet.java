package fr.sae.group1.builder;

/**
 * This class represents a 3-dimensional tuple (point, vector, color).
 * The attributes x, y and z are protected to be accessible by subclasses.
 */
public class Triplet {
    private double x;
    private double y;
    private double z;

    /**
     * Constructs a new Triplet with the given x, y and z values.
     *
     * @param x The x value.
     * @param y The y value.
     * @param z The z value.
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Computes the sum of this triplet and another triplet.
     *
     * @param t The other triplet.
     * @return A new triplet that is the sum of this triplet and the other triplet.
     */
    public Triplet add(Triplet t) {
        return new Triplet(this.x + t.x, this.y + t.y, this.z + t.z);
    }

    /**
     * Computes the difference of this triplet and another triplet.
     *
     * @param t The other triplet.
     * @return A new triplet that is the difference of this triplet and the other
     *         triplet.
     */
    public Triplet sub(Triplet t) {
        return new Triplet(this.x - t.x, this.y - t.y, this.z - t.z);
    }

    /**
     * Computes the product of this triplet by a scalar.
     *
     * @param d The scalar.
     * @return A new triplet that is the product of this triplet and the scalar.
     */
    public Triplet mul(double d) {
        return new Triplet(this.x * d, this.y * d, this.z * d);
    }

    /**
     * Computes the dot product of this triplet with another triplet.
     *
     * @param t The other triplet.
     * @return The dot product of this triplet and the other triplet.
     */
    public double dot(Triplet t) {
        return this.x * t.x + this.y * t.y + this.z * t.z;
    }

    /**
     * Computes the dot Schur product of this triplet with another triplet.
     *
     * @param t The other triplet.
     * @return The Schur product of this triplet and the other triplet.
     */
    public Triplet schur(Triplet t) {
        return new Triplet(this.x*t.x, this.y*t.y, this.z*t.z);
    }

    /**
     * Computes the cross product of this triplet with another triplet.
     *
     * @param t The other triplet.
     * @return A new triplet that is the cross product of this triplet and the other
     *         triplet.
     */
    public Triplet cross(Triplet t) {
        return new Triplet(this.y * t.z - this.z * t.y,
                this.z * t.x - this.x * t.z,
                this.x * t.y - this.y * t.x);
    }

    /**
     * Computes the length of this triplet.
     *
     * @return The length of this triplet.
     */
    public double length() {
        return Math.sqrt(this.dot(this));
    }

    /**
     * Normalizes this triplet (makes it unitary).
     *
     * @return A new normalized version of this triplet if it's not null; otherwise
     *         returns itself.
     */
    public Triplet normalize() {
        double l = this.length();
        if (l == 0) {
            return this; // Cannot normalize a null triplet
        } else {
            return this.mul(1 / l); // Divide by the length
        }
    }

    /**
     * Getter of the double x
     *
     * @return x a double
     */
    public double getX() {
        return x;
    }

    /**
     * Getter of the double y
     *
     * @return y a double
     */
    public double getY() {
        return y;
    }

    /**
     * Getter of the double z
     *
     * @return z a double
     */
    public double getZ() {
        return z;
    }

    /**
     * Verify if this triplet and other object are the same triplet
     *
     * @param obj an object
     * @return true if it's the same triple otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Triplet triplet = (Triplet) obj;
        return Double.compare(triplet.x, x) == 0 &&
            Double.compare(triplet.y, y) == 0 &&
            Double.compare(triplet.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
