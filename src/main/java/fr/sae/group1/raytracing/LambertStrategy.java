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

/**
 * Class LambertStrategy to color a pixel with the lambert strategy.
 */
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
        Point p = new Point((d.mul(mint).add(scene.getCamera().getPosition()).getTriplet()));
        Vector n = shape.getN(p);
        Color col = new Color(0,0,0);
        for (Light light : accessibleLights) {
            if (light instanceof PointLight plight) {
                col = col.add(plight.getColor().multiply(max(n.dot(plight.getPointLightVector(p)), 0)));
            } else {
                DirectionalLight dlight = (DirectionalLight) light;
                col = col.add(dlight.getColor().multiply(max(n.dot(dlight.getDirectionalLightVector()), 0)));
            }
        }
        if (scene.getAmbient() == null) {
            col = col.add(black)
                    .schurProduct(shape.getDiffuse());
        } else {
            col = col.add(scene.getAmbient())
                    .schurProduct(shape.getDiffuse());
        }
        return col;
    }

    }


