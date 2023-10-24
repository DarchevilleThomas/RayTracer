package fr.saeS3A01.group1;

import java.util.ArrayList;

public class SceneBuilder implements Builder{

    private Camera camera;
    private int width;
    private int height;
    private ArrayList<Light> lights;
    private ArrayList<Shape> shapes;

    /**
     * Method to set a new camera
     * @param camera
     */
    @Override
    public void setCamera(Camera camera) {
        this.camera=camera;
    }

    /**
     * Method to set a new width
     * @param width
     */
    @Override
    public void setWidth(int width) {
        this.width=width;
    }

    /**
     * Method to set a new height
     * @param height
     */
    @Override
    public void setHeight(int height) {
        this.height=height;
    }

    /**
     * Method to set a new list of lights
     * @param lights
     */
    @Override
    public void setLights(ArrayList<Light> lights) {
        this.lights=lights;
    }

    /**
     * Method to set a new list of shapes
     * @param shapes
     */
    @Override
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes=shapes;
    }

    /**
     * Method to build a scene with the parameters of the sceneBuilder
     * @return a scene
     */
    public Scene build(){
        return new Scene(camera,width,height,lights,shapes);
    }

}
