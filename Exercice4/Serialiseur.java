package fr.cnam.revision.Exercice4;

import fr.cnam.revision.pralteforme.Plateforme;

public interface Serialiseur {

    /** Sérialiser les données de la plateforme en XML sur le flot out. */
    void serialiser(Plateforme plateforme, java.io.Writer out)
            throws java.io.IOException;
}