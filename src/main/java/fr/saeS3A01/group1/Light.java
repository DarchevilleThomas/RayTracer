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

    // Getter and Setter methods for position and intensity
    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getIntensity() {
        return this.intensity;
    }

    public void setIntensity(Color intensity) {
        this.intensity = intensity;
    }
}