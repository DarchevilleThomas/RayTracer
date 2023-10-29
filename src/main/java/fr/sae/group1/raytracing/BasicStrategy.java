package fr.sae.group1.raytracing;

import java.util.List;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.Light;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

/**
 * Class BasicStrategy to color a pixel with the basic strategy.
 */
public class BasicStrategy implements ColorStrategy{

    /**
     *
     Color Calculation Method with Basic Strategy
     * @param d a Vector
     * @param shape a Shape
     * @param scene a Scene
     * @param mint  a double
     * @return Color
     */
    @Override
    public Color colorCalculation(Vector d, Shape shape, Scene scene, List<Light> accessibleLights, double mint){
        if(scene.getAmbient()==null) return new Color(0,0,0);
        else return scene.getAmbient().multiply(255);
    }
}
