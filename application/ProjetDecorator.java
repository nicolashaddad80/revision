package fr.cnam.revision.application;

import fr.cnam.revision.plateforme.Offre;
import fr.cnam.revision.plateforme.Projet;

import java.util.Iterator;

public abstract class ProjetDecorator implements Projet {
    private static Projet monProjet;

    public ProjetDecorator(Projet monProjet) {
        this.monProjet = monProjet;
    }

    @Override
    public String getNom() {
        return this.getNom();
    }

    @Override
    public int getMontant() {
        return this.getMontant();
    }

    @Override
    public void faireOffre(int montant, double taux) {
    this.monProjet.faireOffre(montant,taux);
    }

    public Iterator<Offre> iterator() {
        return this.monProjet.iterator();
    }

    @Override
    public String toString() {

        return this.monProjet.toString();
    }
}
