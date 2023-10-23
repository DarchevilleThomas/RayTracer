package fr.saeS3A01.group1;

/**
 * DirectionalLight class that represents a light source with a specific direction.
 */
class DirectionalLight extends Light {
    protected Vector direction;

    public DirectionalLight(Point position, Color intensity, Vector direction) {
        super(position, intensity);
        this.direction = direction;
    }
}