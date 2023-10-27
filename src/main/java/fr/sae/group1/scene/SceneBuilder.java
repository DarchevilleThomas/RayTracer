package fr.sae.group1.scene;

import fr.sae.group1.light.Light;
import fr.sae.group1.builder.Camera;
import fr.sae.group1.builder.Color;
import fr.sae.group1.shape.Shape;

import java.util.ArrayList;

public class SceneBuilder implements Builder {

    private Camera camera;
    private int width;
    private int height;
    private final ArrayList<Light> lights = new ArrayList<>();
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private Color ambient;
    private boolean shadow;

    /**
     * Method to set a new camera
     * @param camera a Camera
     */
    @Override
    public void setCamera(Camera camera) {
        this.camera=camera;
    }

    /**
     * Method to set a new ambient color
     * @param ambient a Color
     */
    @Override
    public void setAmbient(Color ambient) {
        this.ambient=ambient;
    }

    /**
     * Method to set a new width
     * @param width int
     */
    @Override
    public void setWidth(int width) {
        this.width=width;
    }

    /**
     * Method to set a new height
     * @param height int
     */
    @Override
    public void setHeight(int height) {
        this.height=height;
    }

    /**
     * Method to add a light in the list
     * @param light Light
     */
    @Override
    public void addLight(Light light) {

        this.lights.add(light);
    }

    /**
     * Method to add a new shape in the list of shapes
     * @param shape a Shape
     */
    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * Method to set a new shadow
     * @param shadow a boolean
     */
    @Override
    public void setShadow(boolean shadow) {
        this.shadow=shadow;
    }

    /**
     * Method to build a scene with the parameters of the sceneBuilder
     * @return a scene
     */
    public Scene build(){
        return new Scene(camera,width,height,lights,shapes,ambient,shadow);
    }

}
