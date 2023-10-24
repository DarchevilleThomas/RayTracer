package fr.saeS3A01.group1;

import java.util.ArrayList;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCamera(Camera camera);
    void setWidth(int width);
    void setHeight(int height);
    void setLights(ArrayList<Light> lights);
    void setShapes(ArrayList<Shape> shapes);
}
