package utils;

public class Utilitaire {
    public static double calculerIMC(double poids, double taille) {
        return Math.round (poids / (taille * taille));

    }
}
