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
        Color last_specular = new Color(0,0,0);
        Color last_diffuse = new Color(0,0,0);
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
                            switch (words.length - 1) {
                                case 3:
                                    verts.add(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])));
                                    break;
                                default:
                                    argumentError("vertex",3,num_line,line);
                            }
                            break;
                        case "size":
                            switch (words.length - 1) {
                                case 2:
                                    scene_builder.setWidth(Integer.parseInt(words[1]));
                                    scene_builder.setHeight(Integer.parseInt(words[2]));
                                    break;
                                default:
                                    argumentError("size",2,num_line,line);
                            }
                            break;
                        case "output":
                            switch (words.length - 1) {
                                case 1:
                                    this.output = words[1];
                                    break;
                                default:
                                    argumentError("output",1,num_line,line);
                            }
                            break;
                        case "camera":
                            switch (words.length - 1) {
                                case 10:
                                    cameras.add(new Camera(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Vector(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9])), Double.parseDouble(words[10])));
                                    break;
                                default:
                                    argumentError("camera",9,num_line,line);
                            }
                            break;
                        case "ambient":
                            switch (words.length - 1) {
                                case 3:
                                    scene_builder.setAmbient(new Color(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3])));
                                    break;
                                default:
                                    argumentError("ambient",3,num_line,line);
                            }
                            break;
                        case "diffuse":
                            switch (words.length - 1) {
                                case 3:
                                    last_diffuse.setTriplet(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]));
                                    break;
                                default:
                                    argumentError("diffuse",3,num_line,line);
                            }
                            break;
                        case "specular":
                            switch (words.length - 1) {
                                case 3:
                                    last_specular.setTriplet(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]));
                                    break;
                                default:
                                    argumentError("specular",3,num_line,line);
                            }
                            break;
                        case "shininess":
                            switch (words.length - 1) {
                                case 1:
                                    last_shininess = Integer.parseInt(words[1]);
                                    break;
                                default:
                                    argumentError("shininess",1,num_line,line);
                            }
                            break;
                        case "tri":
                            switch (words.length - 1) {
                                case 9:
                                    scene_builder.addShape(new Triangle(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]))));
                                    break;
                                case 3:
                                    if (declaredVertex("tri",num_line,line,new int[] {1,2,3},verts)) {
                                        scene_builder.addShape(new Triangle(new Color(last_diffuse), new Color(last_specular), last_shininess, verts.get(Integer.parseInt(words[1])), verts.get(Integer.parseInt(words[2])), verts.get(Integer.parseInt(words[3]))));
                                    }
                                    break;
                                default:
                                    argumentError("tri",9,num_line,line);
                                }
                            break;
                        case "sphere":
                            switch (words.length - 1) {
                                case 4:
                                    scene_builder.addShape(new Sphere(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4])));
                                    break;
                                case 2:
                                    if (declaredVertex("sphere",num_line,line,new int[] {1},verts)) {
                                        scene_builder.addShape(new Sphere(new Color(last_diffuse), new Color(last_specular), last_shininess, verts.get(Integer.parseInt(words[1])), Double.parseDouble(words[2])));
                                    }
                                    break;
                                default:
                                    argumentError("sphere",4,num_line,line);
                            }
                            break;
                        case "plane":
                            switch (words.length - 1) {
                                case 6:
                                    scene_builder.addShape(new Plane(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                                    break;
                                case 4:
                                    if (declaredVertex("sphere",num_line,line,new int[] {1},verts)) {
                                        scene_builder.addShape(new Plane(new Color(last_diffuse), new Color(last_specular), last_shininess, verts.get(Integer.parseInt(words[1])), new Vector(Double.parseDouble(words[2]), Double.parseDouble(words[3]), Double.parseDouble(words[4]))));
                                    }
                                    break;
                                default:
                                    argumentError("sphere",6,num_line,line);
                            }
                            break;
                        case "directional":
                            switch (words.length - 1) {
                                case 6:
                                    scene_builder.addLight(new DirectionalLight(new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4])*255, Double.parseDouble(words[5])*255, Double.parseDouble(words[6])*255)));
                                    break;
                                default:
                                    argumentError("directionnal", 6, num_line, line);
                            }
                            break;
                        case "point":
                            switch (words.length - 1) {
                                case 6:
                                     scene_builder.addLight(new PointLight(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4])*255, Double.parseDouble(words[5])*255, Double.parseDouble(words[6])*255)));
                                    break;
                                default:
                                    argumentError("point", 6, num_line, line);
                            }
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

    private boolean declaredVertex(String func_name, int num_line, String line, int[] check, List<Point> verts) {
        String[] words = line.split("\\s+");
        for (int i : check) {
            try {
                verts.get(Integer.parseInt(words[i]));
            } catch (Exception e) {
                System.err.println("Line (" + num_line + ") : Vertex not declared, currently " + verts.size() + " vertices are declared but you have requested " + words[i] + ".\n" + line);
                StringBuilder sb = new StringBuilder();
                int good = func_name.length();
                for (int j = 1; j <= i - 1; j++) {
                    good = 1 + words[j].length();
                }
                for (int j = 0; j < good; j++) {sb.append(" ");}
                for (int j = good; j < good + words[i].length(); j++) {sb.append("^");}
                System.err.println(sb.toString());
                return false;
            }
        }
        return true;
    }

    private void argumentError(String func_name, int nb_args, int num_line, String line) {
        String[] words = line.split("\\s+");
        System.err.println("Line (" + num_line + ") : Invalid arguments number, " + nb_args + " arguments were expected for the declaration of " + func_name + " but " + (words.length - 1) + " are given.\n" + line);
        StringBuilder sb = new StringBuilder();
        if (words.length < nb_args + 1) {
            for (int i = 0; i < func_name.length(); i++) {sb.append(" ");}
            for (int i = func_name.length(); i < line.length(); i++) {sb.append("^");}
        } else {
            int good = func_name.length();
            for (int i = 1; i <= nb_args; i++) {
                good += 1 + words[i].length();
            }
            for (int i = 0; i < good; i++) {sb.append(" ");}
            for (int i = good; i < line.length(); i++) {sb.append("^");}
        }
        System.err.println(sb.toString());
    }

    /**
     * This method returns the output.
     * @return The output.
     */
    public String getOutput() {
        return this.output;
    }
}