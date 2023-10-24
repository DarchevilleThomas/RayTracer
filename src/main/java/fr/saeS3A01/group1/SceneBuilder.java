package fr.saeS3A01.group1;

import java.util.ArrayList;

public class SceneBuilder implements Builder{

    private Camera camera;
    private int width;
    private int height;
    private ArrayList<Light> lights;
    private ArrayList<Shape> shapes;

    @Override
    public void setCamera(Camera camera) {
        this.camera=camera;
    }

    @Override
    public void setWidth(int width) {
        this.width=width;
    }

    @Override
    public void setHeight(int height) {
        this.height=height;
    }

    @Override
    public void setLights(ArrayList<Light> lights) {
        this.lights=lights;
    }

    @Override
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes=shapes;
    }

    public Scene build(){
        return new Scene(camera,width,height,lights,shapes);
    }

}
