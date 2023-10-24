package fr.saeS3A01.group1;

/**
 * This class represents a PointLight which is a type of Light.
 * It has an additional property 'intensity' represented by a Vector.
 */
class PointLight extends Light {

    /**
     * Constructs a new PointLight with the specified color, position, and intensity.
     *
     * @param color The color of the light.
     * @param position The position of the light.
     */
    PointLight(Color color, Point position) {
        super(position, color);
    }
}
