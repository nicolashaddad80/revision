package fr.cnam.revision.plateforme;

import java.util.ArrayList;
import java.util.Iterator;

public class ProjetConcret implements Projet {
    private String nom;
    private int montant;

    // les offres
    private ArrayList<Offre> mesOffres = new ArrayList();


    public ProjetConcret(String nom, int montant) {
        this.nom = nom;
        this.montant = montant;


    }

    public String getNom() {
        return this.nom;
    }

    public int getMontant() {
        return this.montant;
    }

    public void faireOffre(int montant, double taux) {

    }

    public Iterator<Offre> iterator() {
        return this.mesOffres.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Projet " + this.nom + "(" + this.montant + ")");
        for (Offre offre : this) {
            result.append("\n - " + offre);
        }
        return result.toString();
    }
}
