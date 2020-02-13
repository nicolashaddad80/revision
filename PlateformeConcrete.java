package fr.cnam.revision;

import java.util.Iterator;

public class PlateformeConcrete implements Plateforme {


    public Projet nouveauProjet(String nom, int montant) {
        return null;
    }

    public void faireOffre(String nom, int montant, double taux) {

    }

    public Projet getProjet(String nom) {
        return null;
    }

    public Iterator<Projet> iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Projet projet : this) {
            result.append("\n" + projet);
        }
        return result.toString();
    }
}

