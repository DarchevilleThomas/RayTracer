package fr.sae.group1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger;
    public static void main(String[] args) {
        if (args.length<1){
            logger.log(Level.WARNING,"Enter at list one parameter (the file name)");
        }
        else{
            String filename = args[0];
            SceneParser sceneParser = new SceneParser();
            Scene scene = sceneParser.parseScene(filename);
            String output = sceneParser.getOutput();
            Ray ray = new Ray();
            ray.ray(scene,output,null);
        }

    }
}