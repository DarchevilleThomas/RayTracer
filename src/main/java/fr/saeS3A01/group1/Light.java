package fr.saeS3A01.group1;

/**
 * This abstract class represents a light source.
 * It is meant to be subclassed by specific types of lights.
 */
abstract class Light {
    /**
     * The position of the light source.
     */
    protected Point position;

    /**
     * The color of the light source.
     */
    protected Color color;

    /**
     * Constructs a new Light with the given position and color.
     *
     * @param position The position of the light source.
     * @param color    The color of the light source.
     */
    public Light(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    /**
     * Returns the position of this light source.
     *
     * @return The position of this light source.
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position of this light source to the given position.
     *
     * @param position The new position of this light source.
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Returns the color of this light source.
     *
     * @return The color of this light source.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the color of this light source to the given color.
     *
     * @param color The new color of this light source.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
