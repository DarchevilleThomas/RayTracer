package fr.sae.group1.scene;

import fr.sae.group1.builder.Camera;
import fr.sae.group1.builder.Color;
import fr.sae.group1.builder.Point;
import fr.sae.group1.builder.Vector;
import fr.sae.group1.light.DirectionalLight;
import fr.sae.group1.light.PointLight;
import fr.sae.group1.shape.Plane;
import fr.sae.group1.shape.Sphere;
import fr.sae.group1.shape.Triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static Logger logger = Logger.getLogger(SceneParser.class.getName());

    /**
     * This method parses a scene from a file.
     * @param fileName The name of the file to read.
     * @return The parsed scene.
     */
    public Scene parseScene(String fileName){
        // Default initialization of the scene attributes
        SceneBuilder scenebBuilder = new SceneBuilder();
        Color lastSpecular = new Color(0, 0, 0);
        Color lastDiffuse = new Color(0, 0, 0);
        final String sphere = "sphere";
        int lastShininess = 1;
        List<Point> verts = new ArrayList<>();
        List<Camera> cameras = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            int numLine = 0;
            while (line != null) {
                numLine++;
                // Ignore blank lines or lines that start with #
                if (!line.isBlank() && !line.startsWith("#")) {
                    // Split the line into words by spaces
                    String[] words = line.split("\\s+");
                    switch (words[0]) {
                        case "maxverts":
                            // No use
                            break;
                        case "vertex":
                            if (words.length - 1 == 3) verts.add(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])));
                            else argumentError("vertex", 3, numLine, line);
                            break;
                        case "size":
                            if (words.length - 1 == 2) {
                                scenebBuilder.setWidth(Integer.parseInt(words[1]));
                                scenebBuilder.setHeight(Integer.parseInt(words[2]));
                            } else argumentError("size", 2, numLine, line);
                            break;
                        case "output":
                            if (words.length - 1 == 1) this.output = words[1];
                            else argumentError("output", 1, numLine, line);
                            break;
                        case "camera":
                            if (words.length - 1 == 10) cameras.add(new Camera(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Vector(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9])), Double.parseDouble(words[10])));
                            else argumentError("camera", 9, numLine, line);
                            break;
                        case "ambient":
                            if (words.length - 1 == 3) scenebBuilder.setAmbient(new Color(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])));
                            else argumentError("ambient", 3, numLine, line);
                            break;
                        case "diffuse":
                            if (words.length - 1 == 3) lastDiffuse.setTriplet(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
                            else argumentError("diffuse", 3, numLine, line);
                            break;
                        case "specular":
                            if (words.length - 1 == 3) lastSpecular.setTriplet(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
                            else argumentError("specular", 3, numLine, line);
                            break;
                        case "shininess":
                            if (words.length - 1 == 1) lastShininess = Integer.parseInt(words[1]);
                            else argumentError("shininess", 1, numLine, line);
                            break;
                        case "tri":
                            switch (words.length - 1) {
                                case 9:
                                    scenebBuilder.addShape(new Triangle(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]))));
                                    break;
                                case 3:
                                    if (declaredVertex("tri", numLine, line, new int[]{1, 2, 3}, verts)) scenebBuilder.addShape(new Triangle(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, verts.get(Integer.parseInt(words[1])), verts.get(Integer.parseInt(words[2])), verts.get(Integer.parseInt(words[3]))));
                                    break;
                                default:
                                    argumentError("tri", 9, numLine, line);
                            }
                            break;
                        case sphere:
                            switch (words.length - 1) {
                                case 4:
                                    scenebBuilder.addShape(new Sphere(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4])));
                                    break;
                                case 2:
                                    if (declaredVertex(sphere, numLine, line, new int[]{1}, verts)) scenebBuilder.addShape(new Sphere(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, verts.get(Integer.parseInt(words[1])), Double.parseDouble(words[2])));
                                    break;
                                default:
                                    argumentError(sphere, 4, numLine, line);
                            }
                            break;
                        case "plane":
                            switch (words.length - 1) {
                                case 6:
                                    scenebBuilder.addShape(new Plane(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                                    break;
                                case 4:
                                    if (declaredVertex(sphere, numLine, line, new int[]{1}, verts)) {
                                        scenebBuilder.addShape(new Plane(new Color(lastDiffuse), new Color(lastSpecular), lastShininess, verts.get(Integer.parseInt(words[1])), new Vector(Double.parseDouble(words[2]), Double.parseDouble(words[3]), Double.parseDouble(words[4]))));
                                    }
                                    break;
                                default:
                                    argumentError(sphere, 6, numLine, line);
                            }
                            break;
                        case "directional":
                            if (words.length - 1 == 6) scenebBuilder.addLight(new DirectionalLight(new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]) * 255, Double.parseDouble(words[5]) * 255, Double.parseDouble(words[6]) * 255)));
                            else argumentError("directionnal", 6, numLine, line);
                            break;
                        case "point":
                            if (words.length - 1 == 6) scenebBuilder.addLight(new PointLight(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]) * 255, Double.parseDouble(words[5]) * 255, Double.parseDouble(words[6]) * 255)));
                            else argumentError("point", 6, numLine, line);
                            break;
                        case "shadow":
                            if (words.length - 1 == 1) scenebBuilder.setShadow(Boolean.parseBoolean(words[1]));
                            else argumentError("shadow", 1, numLine, line);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid line " + numLine + ": " + line);
                    }
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            logger.log(Level.WARNING,String.format("Error reading file: %s", e.getMessage()));
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING,String.format("Invalid number format: %s", e.getMessage()));
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARNING,String.format("Invalid argument: %s", e.getMessage()));
        }
        // Close the BufferedReader
        // Add the camera(s)
        if (cameras.isEmpty()) {
            scenebBuilder.setCamera(new Camera(new Point(10, 0, 0), new Point(0, 0, 0), new Vector(1, 0, 1), 45));
        }
        for (Camera camera : cameras) {
            scenebBuilder.setCamera(camera);
        }
        // Build and return the scene
        return scenebBuilder.build();

    }

    private boolean declaredVertex(String funcName, int numLine, String line, int[] check, List<Point> verts) {
        String[] words = line.split("\\s+");
        for (int i : check) {
            try {
                verts.get(Integer.parseInt(words[i]));
            } catch (Exception e) {
                String string = ("Line (" + numLine + ") : Vertex not declared, currently " + verts.size() + " vertices are declared but you have requested " + words[i] + ".\n" + line);
                logger.log(Level.WARNING, string);

                StringBuilder sb = new StringBuilder();
                int good = funcName.length();
                for (int j = 1; j <= i - 1; j++) {
                    good = 1 + words[j].length();
                }
                sb.append(" ".repeat(Math.max(0, good)));
                sb.append("^".repeat(Math.max(0, good + words[i].length() - good)));

                logger.log(Level.WARNING, String.valueOf(sb));
                return false;
            }
        }
        return true;
    }

    private void argumentError(String funcName, int nbArgs, int numLine, String line) {
        String[] words = line.split("\\s+");
        String string = ("Line (" + numLine + ") : Invalid arguments number, " + nbArgs + " arguments were expected for the declaration of " + funcName + " but " + (words.length - 1) + " are given.\n" + line);
        logger.log(Level.WARNING, string);
        StringBuilder sb = new StringBuilder();
        if (words.length < nbArgs + 1) {
            for (int i = 0; i < funcName.length(); i++) {sb.append(" ");}
            for (int i = funcName.length(); i < line.length(); i++) {sb.append("^");}
        } else {
            int good = funcName.length();
            for (int i = 1; i <= nbArgs; i++) {
                good += 1 + words[i].length();
            }
            sb.append(" ".repeat(Math.max(0, good)));
            sb.append("^".repeat(Math.max(0, line.length() - good)));
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






















