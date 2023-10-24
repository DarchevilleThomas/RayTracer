package fr.saeS3A01.group1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneParser {
    private String output;

    public SceneParser() {
        this.output = "";
    }

    // Le constructeur du parser prend en paramètre le nom du fichier à lire
    public Scene parseScene(String fileName) {
        // Initialisation des attributs de la scene par défaut
        SceneBuilder scene_builder = new SceneBuilder();
        Color last_specular = new Color(255,255,255);
        Color last_diffuse = new Color(255,255,255);
        int last_shininess = 1;
        List<Camera> cameras = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                // On ignore les lignes vides ou qui commencent par #
                if (!line.isBlank() && !line.startsWith("#")) {
                    // On sépare la ligne en mots selon les espaces
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
                            scene_builder.setAmbiant(Double.parseDouble(words[1]),Double.parseDouble(words[2]),Double.parseDouble(words[3]));
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
                            scene_builder.addShape(new Triangle(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Point(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6])), new Point(Double.parseDouble(words[7]), Double.parseDouble(words[8]), Double.parseDouble(words[9]))));
                            break;
                        case "sphere":
                            scene_builder.addShape(new Sphere(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), Double.parseDouble(words[4])));
                            break;
                        case "plane":
                            scene_builder.addShape(new Plane(last_diffuse, last_specular, last_shininess, new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Vector(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        case "directional":
                            scene_builder.addLight(new DirectionalLight(new Vector(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        case "point":
                            scene_builder.addLight(new PointLight(new Point(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3])), new Color(Double.parseDouble(words[4]), Double.parseDouble(words[5]), Double.parseDouble(words[6]))));
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid line: " + line);
                    }
                }
                line = reader.readLine();
            }
            // On ferme le BufferedReader
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        }
        // on ajoute le(s) camera(s)
        if (cameras.isEmpty()) {
            scene_builder.setCamera(new Camera(new Point(10,0,0), new Point(0,0,0) , new Vector(1,0,1), 45));
        }
        for (Camera camera : cameras) {
            scene_builder.setCamera(camera);
        }
        // On construit et retourne la scène
        return scene_builder.build();
    }

    public String getOutput() {
        return this.output;
    }
}
