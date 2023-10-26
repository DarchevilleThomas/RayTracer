package fr.sae.group1;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length<1){
            System.err.println("Enter at list one parameter (the file name)");
        }
        else{
            String filename = args[0];
            SceneParser sceneParser = new SceneParser();
            Scene scene = sceneParser.parseScene(filename);
            String output = sceneParser.getOutput();
            ColorStrategy strategy = null;
            Ray ray = new Ray();
            ray.ray(scene,output,strategy);
        }

    }
}