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
}