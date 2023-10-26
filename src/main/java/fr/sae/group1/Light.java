package fr.sae.group1;

/**
 * This abstract class represents a light source.
 * It is meant to be subclassed by specific types of lights.
 */
public abstract class Light {

    /**
     * The color of the light source.
     */
    protected Color color;

    /**
     * Constructs a new Light with the given position and color.
     *
     * @param color    The color of the light source.
     */
    public Light(Color color) {
        this.color = color;
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
