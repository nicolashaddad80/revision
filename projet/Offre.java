package fr.cnam.revision.projet;

public interface Offre extends Comparable<Offre> {
    int getNumero();

    int getMontant();

    double getTaux();
}
