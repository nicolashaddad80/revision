package fr.cnam.revision;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlateformeConcrete extends HashMap<String,Projet> implements Plateforme {

   // private Map<String, Projet> mesProjets = new HashMap<>();

    public Projet nouveauProjet(String nom, int montant) {
        Projet unNouveauProjet = new ProjetConcret(nom, montant);
        this.put(nom, unNouveauProjet);
        return unNouveauProjet;
    }

    public void faireOffre(String nom, int montant, double taux) {

    }

    public Projet getProjet(String nom) {

        return this.get(nom);
    }

    public Iterator<Projet> iterator() {
        return this.values().iterator();
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

