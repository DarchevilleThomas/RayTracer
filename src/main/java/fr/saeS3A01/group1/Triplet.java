package fr.saeS3A01.group1;

// Définir une classe abstraite Triplet pour représenter un tuple de dimension 3
class Triplet {
    // Les attributs x, y et z sont protégés pour être accessibles aux classes filles
    protected double x;
    protected double y;
    protected double z;

    // Le constructeur prend trois paramètres réels
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Les méthodes suivantes sont communes à tous les triplets
    // Elles doivent être redéfinies dans les classes filles si nécessaire
    // Méthode pour calculer la somme de deux triplets
    public Triplet add(Triplet t) {
        return new Triplet(this.x + t.x, this.y + t.y, this.z + t.z);
    }

    // Méthode pour calculer la différence de deux triplets
    public Triplet sub(Triplet t) {
        return new Triplet(this.x - t.x, this.y - t.y, this.z - t.z);
    }

    // Méthode pour calculer le produit par un scalaire
    public Triplet mul(double d) {
        return new Triplet(this.x * d, this.y * d, this.z * d);
    }

    // Méthode pour calculer le produit scalaire avec un autre triplet
    public double dot(Triplet t) {
        return this.x * t.x + this.y * t.y + this.z * t.z;
    }

    // Méthode pour calculer le produit vectoriel avec un autre triplet
    public Triplet cross(Triplet t) {
        return new Triplet(this.y * t.z - this.z * t.y,
                this.z * t.x - this.x * t.z,
                this.x * t.y - this.y * t.x);
    }

    // Méthode pour calculer la longueur du triplet
    public double length() {
        return Math.sqrt(this.dot(this));
    }
}