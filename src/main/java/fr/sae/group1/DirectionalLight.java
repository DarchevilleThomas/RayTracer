package fr.sae.group1;

/**
 * This class represents a directional light source.
 * It extends the Light class and adds a specific direction.
 */
class DirectionalLight extends Light {
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



}
