package fr.sae.group1.raytracing;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.DirectionalLight;
import fr.sae.group1.light.Light;
import fr.sae.group1.light.PointLight;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

import static java.lang.Math.max;

import java.util.List;

public class LambertStrategy implements ColorStrategy{

    /**
     *
     * @param d a Vector
     * @param shape a Shape
     * @param scene a Scene
     * @param mint double
     * @return Color
     */
    @Override
    public Color colorCalculation(Vector d, Shape shape, Scene scene, List<Light> accessibleLights, double mint) {
        Color black = new Color(0, 0, 0);
        BasicStrategy basic = new BasicStrategy();
        Color res;
        Vector n;
        Point p = new Point((d.mul(mint).add(scene.getCamera().getPosition()).getTriplet()));
        n = shape.getN(p);
        if (scene.getAmbient() == null)
            res = new Color(0, 0, 0);
        else
            res = scene.getAmbient();
        for (Light light : accessibleLights) {
            if (light instanceof PointLight plight) {
                res = res.add(shape.getDiffuse().schurProduct(
                        light.getColor().multiply(max(n.dot(plight.getPointLightVector(p)), 0))));
            } else {
                DirectionalLight dlight = (DirectionalLight) light;
                res = res.add((dlight.getColor()
                        .multiply(max(n.dot(dlight.getDirectionalLightVector()), 0))));
            }
        }
        if (scene.getAmbient() == null) {
            return res.add(basic.colorCalculation(d, shape, scene, accessibleLights, mint))
                    .schurProduct(shape.getDiffuse()).add(black);
        } else {
            return res.add(basic.colorCalculation(d, shape, scene, accessibleLights, mint))
                    .schurProduct(shape.getDiffuse()).add(scene.getAmbient());
        }
    }

    }


