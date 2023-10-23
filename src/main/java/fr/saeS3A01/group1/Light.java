package fr.saeS3A01.group1;

/**
 * Light class that represents a light source.
 */
class Light {
    protected Point position;
    protected Color intensity;

    public Light(Point position, Color intensity) {
        this.position = position;
        this.intensity = intensity;
    }
}