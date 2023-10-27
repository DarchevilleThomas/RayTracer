package fr.sae.group1;

import fr.sae.group1.raytracing.LambertStrategy;
import fr.sae.group1.raytracing.PhongStrategy;
import fr.sae.group1.raytracing.Ray;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.scene.SceneParser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length<1){
            logger.log(Level.WARNING,"Enter at list one parameter (the file name)");
        }
        else{
            String filename = args[0];
            SceneParser sceneParser = new SceneParser();
            Scene scene = sceneParser.parseScene(filename);
            String output = sceneParser.getOutput();
            PhongStrategy strategy = new PhongStrategy();
            Ray.ray(scene,output, strategy);
        }

    }
}
