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



}



