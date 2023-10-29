package fr.sae.group1.raytracing;

import java.util.List;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.Light;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

/**
 * Interface to color a pixel
 */
public interface ColorStrategy {
    /**
     * Return a color for a vector, a shape, a scene, a list of light and a double.
     *
     * @param d a vector
     * @param shape a shape
     * @param scene a scene
     * @param accessibleLights a list of light
     * @param mint a double
     * @return a color
     */
    Color colorCalculation(Vector d, Shape shape, Scene scene, List<Light> accessibleLights, double mint);
}
