package fr.sae.group1.light;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Vector;

/**
 * This class represents a directional light source.
 * It extends the Light class and adds a specific direction.
 */
public class DirectionalLight extends Light {
    /**
     * The direction of the light source.
     */
    protected Vector direction;


    /**
     * Constructs a new DirectionalLight with the given position, color, and direction.
     *
     *
     * @param color The color of the light source.
     * @param direction The direction of the light source.
     */
    public DirectionalLight(Vector direction, Color color) {
        super(color);
        this.direction = direction;
    }

    /**
     * Method to get the direction of the light.
     * @return a Vector
     */
    public Vector getDirectionalLightVector(){
        return this.direction.normalize();
    }

    /**
     * Returns a string representation of the DirectionalLight object.
     *
     * @return A string representation of the DirectionalLight object, including the RGB value of its color and its direction.
     */
    @Override
    public String toString() {
        return "DirectionalLight{" +
            "color=" + color +
            ", direction=" + direction +
            '}';
    }
}
