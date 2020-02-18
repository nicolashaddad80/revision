package fr.cnam.revision.Exercice4;

import fr.cnam.revision.pralteforme.Offre;
import fr.cnam.revision.pralteforme.Plateforme;
import fr.cnam.revision.pralteforme.Projet;
import org.jdom.*;
import org.jdom.output.*;

import java.util.Iterator;


public class SerialiseurConcret implements Serialiseur {

    public  void serialiser(Plateforme plateforme, java.io.Writer out)
            throws java.io.IOException
    {
// Création du document XML
        Element racine = new Element("crowdlending");
        DocType docType = new DocType("crowdlending", "crowdlending.dtd");
        Document document = new Document(racine, docType);

        //TODO complete here

        for (Projet projetObject:plateforme) {

            Element xmlProjet = new Element("projet");
            xmlProjet.setAttribute(new Attribute("nom", projetObject.getNom()));
            Element xmlMontant = new Element("montant");
            xmlMontant.setText(Integer.toString(projetObject.getMontant()));
            xmlProjet.addContent(xmlMontant);

            for (Iterator<Offre> it = projetObject.iterator(); it.hasNext(); ) {
                Offre offreObject = it.next();
                Element xmlOffre = new Element("offre");
                xmlOffre.setAttribute(new Attribute("montant",Integer.toString(offreObject.getMontant())));
                xmlOffre.setAttribute(new Attribute("taux",Double.toString(offreObject.getTaux())));
                xmlOffre.setAttribute(new Attribute("numero",Integer.toString(offreObject.getNumero())));
                xmlOffre.setAttribute(new Attribute("etat",offreObject.getEtat().offerState));
                xmlProjet.addContent(xmlOffre);
            }
            racine.addContent(xmlProjet);
        }


        //TODO finish Complete here

        // Production du fichier XML
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, out);
    }
}