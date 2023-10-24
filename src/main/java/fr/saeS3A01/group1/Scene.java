package fr.saeS3A01.group1;

import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private int width;
    private int height;
    private ArrayList<Light> lights;
    private ArrayList<Shape> shapes;

    public Scene(Camera camera, int width, int height) {
        this.camera = camera;
        this.width = width;
        this.height = height;
        this.lights = new ArrayList<Light>();
        this.shapes = new ArrayList<Shape>();
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Light> getLights() {
        return lights;
    }

    public void setLights(ArrayList<Light> lights) {
        this.lights = lights;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }
}



