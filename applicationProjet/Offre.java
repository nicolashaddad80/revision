package fr.cnam.revision.applicationProjet;

public interface Offre extends Comparable<Offre> {
    int getNumero();

    int getMontant();

    double getTaux();
}
