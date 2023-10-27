package fr.sae.group1.shadow;

import java.util.ArrayList;
import java.util.List;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.Light;
import fr.sae.group1.light.PointLight;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

public class BasicShadow implements ShadowStrategy {

    @Override
    public List<Light> accessibleLights(Scene scene, Shape lastShape, Vector d) throws Exception {
        List<Light> lights = scene.getLights();
        Point lookAt = scene.getCamera().getTarget();
        List<Light> clights = new ArrayList<>();
        if (lastShape != null) {
            for (Light light : lights) {
                if (light instanceof PointLight) {
                    Point lightPosition = ((PointLight) light).getPosition();
                    Vector lightDirection = lastShape.intersection(lookAt, d).sub(lightPosition);
                    boolean obscured = false;
                    for (Shape shape : scene.getShapes()) {
                        if (shape == lastShape) continue; // Ignorer la forme en contact avec le rayon de la caméra
                        Point intersection = shape.intersection(lookAt, lightDirection);
                        if (intersection != null && lightPosition.distance(shape.intersection(lightPosition, lightDirection)) < lightPosition.distance(intersection)) {
                            obscured = true;
                            break;
                        }
                    }
                    if (!obscured) clights.add(light);
                } else clights.add(light);
            }
        } else clights.addAll(lights);
        return clights;
    }
}
