package fr.saeS3A01.group1;

/**
 * This class represents a PointLight which is a type of Light.
 * It has an additional property 'intensity' represented by a Vector.
 */
class PointLight extends Light {
    protected Vector intensity;

    /**
     * Constructs a new PointLight with the specified color, position, and intensity.
     *
     * @param color The color of the light.
     * @param position The position of the light.
     * @param intensity The intensity of the light.
     */
    PointLight(Color color, Point position, Vector intensity) {
        super(position, color);
        this.intensity = intensity;
    }

    /**
     * Returns the intensity of this PointLight.
     *
     * @return The intensity of this PointLight.
     */
    public Vector getIntensity() {
        return this.intensity;
    }
}
