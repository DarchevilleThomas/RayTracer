package fr.saeS3A01.group1;

/**
 * This class represents a PointLight which is a type of Light.
 */
class PointLight extends Light {
    /**
     * The position of the light source.
     */
    protected Point position;

    /**
     * Constructs a new PointLight with the specified color, position, and intensity.
     *
     * @param color The color of the light.
     * @param position The position of the light.
     * @param intensity The intensity of the light.
     */
    PointLight(Color color, Point position) {
        super(color);
        this.position = position;
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
}
