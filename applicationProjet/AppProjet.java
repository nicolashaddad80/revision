package fr.cnam.revision.applicationProjet;

import fr.cnam.revision.pralteforme.ProjetConcret;

/**
 * This is Singleton for Projet
 */
public class AppProjet {

    //Only one instance of Projet is created.
    private static ObservableProjet monObservableProjet = new ObservableProjet(new ProjetConcret("XYZ", 120000));

    //private constructor to avoid client applications to use constructor
    private AppProjet() {
    }

    public static ObservableProjet getMonObservableProjet() {
        return monObservableProjet;
    }
}
