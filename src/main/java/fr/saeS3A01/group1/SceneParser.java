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
        List<Camera> cameras = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                // Ignore blank lines or lines that start with #
                if (!line.isBlank() && !line.startsWith("#")) {
                    // Split the line into words by spaces
                    String[] words = line.split("\\s+");
                    switch (words[0]) {
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
                            scene_builder.setAmbient(new Color(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3])));
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
                            scene_builder.addShape(new Triangle(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]))));
                            break;
                        case "sphere":
                            scene_builder.addShape(new Sphere(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4])));
                            break;
                        case "plane":
                            scene_builder.addShape(new Plane(new Color(last_diffuse), new Color(last_specular), last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        case "directional":
                            scene_builder.addLight(new DirectionalLight(new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4])*255, Double.parseDouble(words[5])*255, Double.parseDouble(words[6])*255)));
                            break;
                        case "point":
                            scene_builder.addLight(new PointLight(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4])*255, Double.parseDouble(words[5])*255, Double.parseDouble(words[6])*255)));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid line: " + line);
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

    /**
     * This method returns the output.
     * @return The output.
     */
    public String getOutput() {
        return this.output;
    }
}
