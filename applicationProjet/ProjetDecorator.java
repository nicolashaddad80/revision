package fr.cnam.revision.applicationProjet;

import fr.cnam.revision.projet.Offre;
import fr.cnam.revision.projet.Projet;

import java.util.Iterator;

public abstract class ProjetDecorator implements Projet {
    private static Projet monProjet;

    public ProjetDecorator(Projet monProjet) {
        this.monProjet = monProjet;
    }

    @Override
    public String getNom() {
        return this.monProjet.getNom();
    }

    @Override
    public int getMontant() {
        return this.monProjet.getMontant();
    }

    @Override
    public void faireOffre(int montant, double taux) {
        this.monProjet.faireOffre(montant, taux);
    }

    public Iterator<Offre> iterator() {
        return this.monProjet.iterator();
    }

    @Override
    public String toString() {

        return this.monProjet.toString();
    }

}
