package fr.saeS3A01.group1;


import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

import static java.lang.Math.max;

public class LambertStrategy implements ColorStrategy{

    /**Method for calculating the color of a point using Lambert's method
     * @return Color
     */
    @Override
    public Color colorCalculation(Shape shape, Point p, ArrayList<Light> lights, Scene scene, Vector d) throws Exception {
        Color res = null;
        Vector n = new Vector(0,0,0);
        if (shape instanceof Sphere) {
            n = (p.sub(((Sphere) shape).getP())).normalize();
        }

        else if (shape instanceof Triangle) {
            n = (p.sub(((Triangle) shape).getPoint1())).normalize();

        }

        else if (shape instanceof Plane) {
            n = (p.sub(((Plane) shape).getPoint())).normalize();
        }

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
