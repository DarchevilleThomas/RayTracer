package fr.saeS3A01.group1;

/**
 * Ray class that represents a ray of light.
 */
class Ray {
    protected Point origin;
    protected Vector direction;

    public Ray(Point origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    // Getter and Setter methods for origin and direction
    public Point getOrigin() {
        return this.origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Vector getDirection() {
        return this.direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }
}
