package fr.sae.group1.scene;

import fr.sae.group1.builder.Checker;
import fr.sae.group1.light.Light;
import fr.sae.group1.builder.Camera;
import fr.sae.group1.builder.Color;
import fr.sae.group1.shape.Shape;

import java.util.List;

/**
 * Scene class to create a scene to position elements
 */
public class Scene {
    private Camera camera;
    private int width;
    private int height;
    private List<Light> lights;
    private List<Shape> shapes;
    private Color ambient;
    private boolean shadow;
    private int maxDepth;
    private Checker checker;

    /**
     * Constructor for a scene with lights, shapes and ambient color.
     * @param camera a Camera
     * @param width int
     * @param height int
     * @param lights List of Light
     * @param shapes List of Shape
     * @param ambient a Color
     * @param maxDepth a int
     */
    public Scene(Camera camera, int width, int height, List<Light> lights, List<Shape> shapes, Color ambient, int maxDepth) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = lights;
        this.shapes = shapes;
        this.ambient = ambient;
        this.maxDepth = maxDepth;
    }

    /**
     *  Getter for ambient color
     *
     * @return a color
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

    /**
     * Method to know is there is a shadow or not
     *
     * @return a boolean
     */
    public boolean isShadow() {
        return shadow;
    }

    /**
     * Getter for maxDepth
     * @return int the maxDepth
     */
    public int getMaxDepth() { return maxDepth; }

    /**
     * Setter for maxDepth
     * @param maxDepth int
     */
    public void setMaxDepth(int maxDepth) {this.maxDepth = maxDepth;}

    /**
     * Getter for a checker
     *
     * @return a checker
     */
    public Checker getChecker() {
        return checker;
    }

    /**
     * Setter for a checker
     *
     * @param checker a checker
     */
    public void setChecker(Checker checker) {
        this.checker = checker;
    }
}



