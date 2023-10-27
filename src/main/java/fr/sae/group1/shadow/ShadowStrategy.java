package fr.sae.group1.shadow;

import java.util.List;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.Light;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

public interface ShadowStrategy {
    /**
     * Method that returns the list of light sources accessible from a point on an object.
     * @param scene
     * @param lastShape
     * @param d
     * @return List<Light>
     * @throws Exception
     */
    List<Light> accessibleLights(Scene scene,Shape lastShape,Vector d) throws Exception;
}