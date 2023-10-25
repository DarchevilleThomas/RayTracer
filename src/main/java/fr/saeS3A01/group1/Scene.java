package fr.saeS3A01.group1;

import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private int width;
    private int height;
    private ArrayList<Light> lights;
    private ArrayList<Shape> shapes;
    private Color ambient;

    /**
     * Constructor for Scene class
     * @param camera a Camera
     * @param width a int
     * @param height a int
     */
    public Scene(Camera camera, int width, int height) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = new ArrayList<Light>();
        this.shapes = new ArrayList<Shape>();
        this.ambient = new Color(255,255,255);
    }

    /**
     * Constructor for a scene with lights and shapes.
     * @param camera
     * @param width
     * @param height
     * @param lights
     * @param shapes
     */
    public Scene(Camera camera, int width, int height,ArrayList<Light> lights,ArrayList<Shape> shapes) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = lights;
        this.shapes = shapes;
        this.ambient = new Color(255,255,255);
    }

    /**
     * Constructor for a scene with lights, shapes and ambient color.
     * @param camera
     * @param width
     * @param height
     * @param lights
     * @param shapes
     * @param ambient
     */
    public Scene(Camera camera, int width, int height, ArrayList<Light> lights, ArrayList<Shape> shapes, Color ambient) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = lights;
        this.shapes = shapes;
        this.ambient = ambient;
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
     * @param ambient
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
    public ArrayList<Light> getLights() {
        return lights;
    }

    /**
     *  Setter for lights
     * @param lights ArrayList of Light
     */
    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    /**
     *  Getter for shapes
     * @return ArrayList of Shape
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Setter for shapes
     * @param shapes ArrayList of Shape
     */
    public void setShapes(ArrayList<Shape> shapes) {
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

}



