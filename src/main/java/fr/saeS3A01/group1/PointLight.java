package fr.saeS3A01.group1;

/**
 * This class represents a PointLight which is a type of Light.
 */
class PointLight extends Light {

    /**
     * Constructs a new PointLight with the specified color, position, and intensity.
     *
     * @param color The color of the light.
     * @param position The position of the light.
     * @param intensity The intensity of the light.
     */
    PointLight(Color color, Point position) {
        super(position, color);
    }
}
