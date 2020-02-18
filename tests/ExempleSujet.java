package fr.cnam.revision.tests;

import fr.cnam.revision.Exercice4.Serialiseur;
import fr.cnam.revision.Exercice4.SerialiseurConcret;
import fr.cnam.revision.pralteforme.Plateforme;
import fr.cnam.revision.pralteforme.PlateformeConcrete;

import java.io.FileWriter;
import java.io.Writer;

public class ExempleSujet {

    static public Plateforme getPlateformeSujet() {
        Plateforme exemple = new PlateformeConcrete();
        exemple.nouveauProjet("XYZ", 120000);
        exemple.faireOffre("XYZ", 50, 7.5);
        exemple.faireOffre("XYZ", 90, 8.3);
        exemple.faireOffre("XYZ", 20, 9.9);
        exemple.faireOffre("XYZ", 50, 5.0);
        exemple.faireOffre("XYZ", 68, 6.9);
        exemple.nouveauProjet("ABC", 30000);
        return exemple;
    }

    public static void main(String[] args) throws Exception {
        Plateforme exemple = getPlateformeSujet();

        //TO Clean Surround with try catch

        Writer monFichierxml=new FileWriter("ExempleSujetPlateforme.xml");

        Serialiseur monSerialiseur= new SerialiseurConcret();

        //TO Clean Surround with try catch
        monSerialiseur.serialiser(exemple,monFichierxml);

        //TO Clean use auto closable
        monFichierxml.close();


    }
}
