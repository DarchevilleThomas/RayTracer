package fr.sae.group1;

import fr.sae.group1.raytracing.Ray;
import fr.sae.group1.scene.Scene;
import fr.sae.group1.scene.SceneParser;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Main execute the raytracer with a parameter (the name of the test file)
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * Method using the raytracer for the file passed in parameter
     *
     * @param args name of the test file
     */
    public static void main(String[] args) {
        if (args.length<1){
            logger.log(Level.WARNING,"Enter at list one parameter (the file name)");
        }
        else{
            String filename = args[0];
            SceneParser sceneParser = new SceneParser();
            Scene scene = sceneParser.parseScene(filename);
            String output = sceneParser.getOutput();
            Ray.ray(scene,output);
        }

    }
}
