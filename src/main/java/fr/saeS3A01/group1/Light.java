package fr.saeS3A01.group1;

/**
 * Light class that represents a light source.
 */
abstract class Light {
    protected Point position;
    protected Color color;

    public Light(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    // Getter and Setter methods for position and color
    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}