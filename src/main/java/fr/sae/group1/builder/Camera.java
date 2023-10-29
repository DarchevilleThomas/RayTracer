package fr.sae.group1.builder;

/**
 * This class represents a camera in a 3D scene, with a position, a target, an up vector and a field of view.
 */
public class Camera {
    private final Point position; // The position of the camera
    private final Point target; // The point the camera is looking at
    private final Vector up; // The up direction of the camera
    private final double fov; // The field of view angle in degrees

    /**
     * Constructs a new Camera with the given parameters.
     */
    public Camera(Point position, Point target, Vector up, double fov) {
        this.position = position;
        this.target = target;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Returns the position of the camera.
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     * Returns the target of the camera.
     */
    public Point getTarget() {
        return this.target;
    }

    /**
     * Returns the up vector of the camera.
     */
    public Vector getUp() {
        return this.up;
    }

    /**
     * Returns the field of view angle of the camera in degrees.
     */
    public double getFov() {
        return this.fov;
    }


}