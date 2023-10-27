package fr.sae.group1.scene;

import fr.sae.group1.builder.Camera;
import fr.sae.group1.builder.Color;
import fr.sae.group1.light.Light;
import fr.sae.group1.shape.Shape;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {

    /**
     * Method to set a new camera.
     * @param camera a Camera
     */
    void setCamera(Camera camera);

    /**
     * Method to set a new ambient color.
     * @param ambient a Color
     */
    void setAmbient(Color ambient);

    /**
     * Method to set a new width
     * @param width int
     */
    void setWidth(int width);

    /**
     * Method to set a new height
     * @param height int
     */
    void setHeight(int height);

    /**
     * Method to add a new light in the list of lights.
     * @param light a Light
     */
    void addLight(Light light);

    /**
     * Method to add a new shape in the list of shapes.
     * @param shape a Shape
     */
    void addShape(Shape shape);

    /**
     * Method to set a new shadow
     * @param shadow a boolean
     */
    void setShadow(boolean shadow);
}
