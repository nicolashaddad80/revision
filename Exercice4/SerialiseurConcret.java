package fr.cnam.revision.Exercice4;

import fr.cnam.revision.pralteforme.Offre;
import fr.cnam.revision.pralteforme.Plateforme;
import fr.cnam.revision.pralteforme.Projet;
import org.jdom.*;
import org.jdom.output.*;

import java.util.Iterator;

public class SerialiseurConcret implements Serialiseur {

    public void serialiser(Plateforme plateforme, java.io.Writer out)
            throws java.io.IOException
    {
// Création du document XML
        Element racine = new Element("crowdlending");
        DocType docType = new DocType("crowdlending", "crowdlending.dtd");
        Document document = new Document(racine, docType);

        //TODO complete here

        for (Projet projetObject:plateforme) {
            Element xmlProjet = new Element("projet");
            xmlProjet.setAttribute(new Attribute("nom",projetObject.getNom()));

            Element xmlMontant = new Element("projet");
            xmlMontant.setText(Integer.toString(projetObject.getMontant()));
            xmlMontant.addContent(xmlMontant);

            for (Iterator<Offre> it = projetObject.iterator(); it.hasNext(); ) {
                Offre offreObject = it.next();
                Element xmlOffre = new Element("offre");
                xmlMontant.setAttribute(new Attribute("montant",Integer.toString(offreObject.getMontant())));
                xmlMontant.setAttribute(new Attribute("taux",Double.toString(offreObject.getTaux())));
                xmlMontant.setAttribute(new Attribute("numéro",Integer.toString(offreObject.getNumero())));
                xmlMontant.setAttribute(new Attribute("état",offreObject.getEtat().toString()));
            }

        }

        //TODO finish Complete here

        // Production du fichier XML
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, out);
    }
}