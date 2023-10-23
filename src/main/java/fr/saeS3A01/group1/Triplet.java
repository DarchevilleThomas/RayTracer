package fr.saeS3A01.group1;

/**
 * An abstract class to represent a 3-dimensional tuple (point, vector, color)
 */
class Triplet {
    // The attributes x, y and z are protected to be accessible by subclasses
    protected double x;
    protected double y;
    protected double z;

    // The constructor takes three real parameters
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // The following methods are common to all triplets
    // They should be overridden in subclasses if necessary
    // Method to compute the sum of two triplets
    public Triplet add(Triplet t) {
        return new Triplet(this.x + t.x, this.y + t.y, this.z + t.z);
    }

    // Method to compute the difference of two triplets
    public Triplet sub(Triplet t) {
        return new Triplet(this.x - t.x, this.y - t.y, this.z - t.z);
    }

    // Method to compute the product by a scalar
    public Triplet mul(double d) {
        return new Triplet(this.x * d, this.y * d, this.z * d);
    }

    // Method to compute the dot product with another triplet
    public double dot(Triplet t) {
        return this.x * t.x + this.y * t.y + this.z * t.z;
    }

    // Method to compute the cross product with another triplet
    public Triplet cross(Triplet t) {
        return new Triplet(this.y * t.z - this.z * t.y,
                this.z * t.x - this.x * t.z,
                this.x * t.y - this.y * t.x);
    }

    // Method to compute the length of the triplet
    public double length() {
        return Math.sqrt(this.dot(this));
    }

    // Method to normalize the triplet (make it unitary)
    public Triplet normalize() {
        double l = this.length();
        if (l == 0) {
            return this; // Cannot normalize a null triplet
        } else {
            return this.mul(1 / l); // Divide by the length
        }
    }
}
