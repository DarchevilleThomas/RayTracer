package fr.saeS3A01.group1;

import java.util.ArrayList;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {

    /**
     * Method to set a new camera.
     * @param camera
     */
    void setCamera(Camera camera);

    /**
     * Method to set a new width
     * @param width
     */
    void setWidth(int width);

    /**
     * Method to set a new height
     * @param height
     */
    void setHeight(int height);

    /**
     * Method to set a new list of lights
     * @param lights
     */
    void setLights(ArrayList<Light> lights);

    /**
     * Method to set a new list of shapes
     * @param shapes
     */
    void setShapes(ArrayList<Shape> shapes);
}
