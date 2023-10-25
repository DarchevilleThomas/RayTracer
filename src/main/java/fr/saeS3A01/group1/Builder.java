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
     * Method to set a new ambient color.
     * @param ambient
     */
    void setAmbient(Color ambient);

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
     * Method to add a new light in the list of lights.
     * @param light
     */
    void addLight(Light light);

    /**
     * Method to add a new shape in the list of shapes.
     * @param shape
     */
    void addShape(Shape shape);
}
