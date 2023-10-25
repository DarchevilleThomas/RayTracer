package fr.saeS3A01.group1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to parse a scene from a file.
 */
public class SceneParser {
    private String output;

    /**
     * Default constructor for the SceneParser class.
     */
    public SceneParser() {
        this.output = "";
    }

    /**
     * This method parses a scene from a file.
     * @param fileName The name of the file to read.
     * @return The parsed scene.
     */
    public Scene parseScene(String fileName) {
        // Default initialization of the scene attributes
        SceneBuilder scene_builder = new SceneBuilder();
        Color last_specular = new Color(255,255,255);
        Color last_diffuse = new Color(255,255,255);
        int last_shininess = 1;
        List<Point> verts = new ArrayList<>();
        List<Camera> cameras = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int num_line = 0;
            while (line != null) {
                num_line++;
                // Ignore blank lines or lines that start with #
                if (!line.isBlank() && !line.startsWith("#")) {
                    // Split the line into words by spaces
                    String[] words = line.split("\\s+");
                    switch (words[0]) {
                        case "maxverts":
                            // No use
                            break;
                        case "vertex":
                            verts.add(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])));
                            break;
                        case "size":
                            scene_builder.setWidth(Integer.parseInt(words[1]));
                            scene_builder.setHeight(Integer.parseInt(words[2]));
                            break;
                        case "output":
                            this.output = words[1];
                            break;
                        case "camera":
                             cameras.add(new Camera(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Vector(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9])), Double.parseDouble(words[10])));
                            break;
                        case "ambient":
                            scene_builder.setAmbient(new Color(Double.parseDouble(words[1])*255,Double.parseDouble(words[2])*255,Double.parseDouble(words[3])*255));
                            break;
                        case "diffuse":
                            last_diffuse.setTriplet(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]));
                            break;
                        case "specular":
                            last_specular.setTriplet(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]));
                            break;
                        case "shininess":
                            last_shininess = Integer.parseInt(words[1]);
                            break;
                        case "tri":
                            switch (words.length) {
                                case 9:
                                    scene_builder.addShape(new Triangle(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]))));
                                    break;
                                case 4:
                                    for (int i = 0; i < words.length; i++) {
                                        if (Integer.parseInt(words[i])*Integer.parseInt(words[i]) >= verts.size()*verts.size()) {
                                            StringBuilder sb = new StringBuilder();
                                            for (int j = 0; j <= 3 + 2*i; j++) {sb.append(' ');}
                                            for (int j = 3 + 2*i + 1; j < line.length(); j++) {sb.append('^');}
                                            System.err.println("Error : no vertex define at index " + words[i] + "\n line " + num_line + " : \n" + line + "\n" + sb.toString());
                                            break;
                                        }
                                    }
                                    scene_builder.addShape(new Triangle(last_diffuse, last_specular, last_shininess, verts.get(Integer.parseInt(words[1])), verts.get(Integer.parseInt(words[2])), verts.get(Integer.parseInt(words[3]))));
                                    break;
                                default:
                                    defaultError("tri",9,num_line,line);
                                }
                            break;
                        case "sphere":
                            switch (words.length) {
                                case 5:
                                    scene_builder.addShape(new Sphere(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4])));
                                    break;
                                case 3:
                                    if (declaredVertex("sphere",num_line,line,verts)) {
                                        scene_builder.addShape(new Sphere(last_diffuse, last_specular, last_shininess, verts.get(Integer.parseInt(words[1])), Double.parseDouble(words[2])));
                                    }
                                    break;
                                default:
                                    System.err.println("case default");
                                    defaultError("sphere",5,num_line,line);
                            }
                            break;
                        case "plane":
                            if (words.length > 5) {
                                scene_builder.addShape(new Plane(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            } else {
                                if (Integer.parseInt(words[1]) < verts.size()) {
                                    scene_builder.addShape(new Plane(last_diffuse, last_specular, last_shininess, verts.get(Integer.parseInt(words[1]) - 1), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                                } else {
                                    System.err.println("Error : no vertex define at index " + words[1]);
                                }
                            }
                            break;
                        case "directional":
                            scene_builder.addLight(new DirectionalLight(new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        case "point":
                            scene_builder.addLight(new PointLight(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid line " + num_line + ": " + line);
                    }
                }
                line = reader.readLine();
            }
            // Close the BufferedReader
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        }
        // Add the camera(s)
        if (cameras.isEmpty()) {
            scene_builder.setCamera(new Camera(new Point(10,0,0), new Point(0,0,0) , new Vector(1,0,1), 45));
        }
        for (Camera camera : cameras) {
            scene_builder.setCamera(camera);
        }
        // Build and return the scene
        return scene_builder.build();
    }

    private boolean declaredVertex(String func_name, int num_line, String line, List<Point> verts) {
        String[] words = line.split("\\s+");
        int name_size = func_name.length();
        for (int i = 0; i < words.length; i++) {
            if (Integer.parseInt(words[i])*Integer.parseInt(words[i]) >= verts.size()*verts.size()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <= name_size + 2*i; j++) {sb.append(' ');}
                for (int j = name_size + 2*i + 1; j < line.length(); j++) {sb.append('^');}
                System.err.println("Error : no vertex define at index " + words[i] + "\n line " + num_line + " : \n" + line + "\n" + sb.toString());
                return false;
            }
            System.err.println("case 3");
        }
        return true;
    }

    private void defaultError(String func_name, int max, int num_line, String line) {
        StringBuilder sb = new StringBuilder();
        int name_size = func_name.length();
        if (line.split("\\s+").length > max) {
            for (int j = 0; j <= name_size + 2*max; j++) {sb.append(' ');}
            for (int j = name_size + 2*max + 1; j < line.length(); j++) {sb.append('^');}
            System.err.println("Error : too many arguments for " + func_name + " at line " + num_line + " : \n" + line + "\n" + sb.toString());
        } else {
            for (int j = 0; j <= name_size; j++) {sb.append(' ');}
            for (int j = name_size + 1; j < line.length(); j++) {sb.append('^');}
            System.err.println("Error : not enough arguments to " + func_name + " at line " + num_line + " : \n" + line + "\n" + sb.toString());
        }
    }

    /**
     * This method returns the output.
     * @return The output.
     */
    public String getOutput() {
        return this.output;
    }
}