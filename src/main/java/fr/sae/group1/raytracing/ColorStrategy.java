package fr.sae.group1.raytracing;

import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.shape.Shape;

public interface ColorStrategy {
    Color colorCalculation(Vector d, Shape shape, Scene scene, double mint);

}
