package fr.sae.group1.scene;

import fr.sae.group1.light.Light;
import fr.sae.group1.builder.Camera;
import fr.sae.group1.builder.Color;
import fr.sae.group1.shape.Shape;

import java.util.List;


public class Scene {
    private Camera camera;
    private int width;
    private int height;
    private List<Light> lights;
    private List<Shape> shapes;
    private Color ambient;
    private boolean shadow;

    /**
     * Constructor for a scene with lights, shapes and ambient color.
     * @param camera a Camera
     * @param width int
     * @param height int
     * @param lights List of Light
     * @param shapes List of Shape
     * @param ambient a Color
     */
    public Scene(Camera camera, int width, int height, List<Light> lights, List<Shape> shapes, Color ambient, boolean shadow) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = lights;
        this.shapes = shapes;
        this.ambient = ambient;
        this.shadow = shadow;
    }

    /**
     *  Getter for ambient color
     *
     */
    public Color getAmbient() {
        return this.ambient;
    }

    /**
     *  Setter for ambient color
     * @param ambient a Color
     */
    public void setAmbient(Color ambient) {
        this.ambient = ambient;
    }

    /**
     *  Getter for camera
     * @return Camera
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     *  Setter for camera
     * @param camera a Camera
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     *  Getter for width
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     *  Setter for width
     * @param width a int
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *  Getter for height
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     *  Setter for height
     * @param height a int
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *  Getter for lights
     * @return ArrayList of Light
     */
    public List<Light> getLights() {
        return lights;
    }

    /**
     *  Setter for lights
     * @param lights ArrayList of Light
     */
    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    /**
     *  Getter for shapes
     * @return ArrayList of Shape
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Setter for shapes
     * @param shapes ArrayList of Shape
     */
    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     *  Method to add a light item to the lights list
     * @param light a Light
     */
    public void addLight(Light light){
        this.lights.add(light);
    }

    /**
     *
     Method to add a shape element to the shapes list
     * @param shape a Shape
     */
    public void addShape(Shape shape){
        this.shapes.add(shape);
    }

    /**
     * Method for shadow
     *
     * @param shadow a boolean
     */
    public void setShadow(boolean shadow) {
        this.shadow = shadow;
    }
}



