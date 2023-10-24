package fr.saeS3A01.group1;

public class Main {
    public static void main(String[] args) {
        if (args.length<1){
            System.err.println("Enter at list one parameter (the file name)");
        }
        else{
            String filename = args[0];
            SceneParser sceneParser = new SceneParser();
            Scene scene = sceneParser.parseScene(filename);
            String output = sceneParser.getOutput();
        }

    }
}