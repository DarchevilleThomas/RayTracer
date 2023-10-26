package fr.saeS3A01.group1;


import java.util.ArrayList;

import static java.lang.Math.max;

public class LambertStrategy implements ColorStrategy{

    /**Method for calculating the color of a point using Lambert's method
     * @return Color
     */
    @Override
    public Color colorCalculation(Sphere sphere, Point p, ArrayList<Light> lights, Scene scene) throws Exception {
        Color res;
        Vector n = (p.sub(sphere.getP())).normalize();
        if( scene.getAmbient()==null) res = new Color(0,0,0); else res = scene.getAmbient();
        for (Light light : lights) {
            if (light instanceof PointLight) {
                PointLight plight = (PointLight) light;
                res = res.add(sphere.getDiffuse().schurProduct(light.getColor().multiply(max(n.dot(plight.getPointLightVector(p)), 0))));
            } else {
                DirectionalLight dlight = (DirectionalLight) light;
                res = res.add((dlight.getColor().multiply(max(n.dot(dlight.getDirectionalLightVector()), 0))));
            }
        }
        return res;
    }
}
