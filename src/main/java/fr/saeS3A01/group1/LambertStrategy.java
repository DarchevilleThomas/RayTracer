package fr.saeS3A01.group1;


import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

import static java.lang.Math.max;

public class LambertStrategy implements ColorStrategy{

    /**
     * Method for calculating the color of a point using Lambert's method
     * @param shape
     * @param p
     * @param lights
     * @param scene
     * @param d
     * @return a color
     * @throws Exception
     */
    @Override
    public Color colorCalculation(Shape shape, Point p, ArrayList<Light> lights, Scene scene, Vector d) throws Exception {
        Color res = null;
        Vector n = new Vector(0,0,0);
        n = shape.getN(p);
        if (scene.getAmbient() == null) res = new Color(0, 0, 0);
        else res = scene.getAmbient();
        for (Light light : lights) {
            if (light instanceof PointLight) {
                PointLight plight = (PointLight) light;
                res = res.add(shape.getDiffuse().schurProduct(light.getColor().multiply(max(n.dot(plight.getPointLightVector(p)), 0))));
            } else {
                DirectionalLight dlight = (DirectionalLight) light;
                res = res.add((dlight.getColor().multiply(max(n.dot(dlight.getDirectionalLightVector()), 0))));
            }
        }
        return res;
    }
}
