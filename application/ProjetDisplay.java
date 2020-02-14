package fr.cnam.revision.application;


import fr.cnam.revision.plateforme.Offre;
import fr.cnam.tp12.mypatterns.MyObserver;

import javax.swing.*;
import java.util.Iterator;


public class ProjetDisplay extends JPanel implements MyObserver {


    //ToClean by using Singleton ???
    private ObservableProjet monObservableProjett;

    private JTextArea Projetdisplay;
    private JLabel infoProjet;


    public ProjetDisplay(ObservableProjet unObservableProjet) {
        this.monObservableProjett = unObservableProjet;
        this.monObservableProjett.addObserver(this);

        this.infoProjet = new JLabel();
        this.Projetdisplay = new JTextArea();
        this.Projetdisplay.setLineWrap(true);
        this.Projetdisplay.setWrapStyleWord(true);
        this.Projetdisplay.setEditable(false);
        this.Projetdisplay.setColumns(45);
        this.Projetdisplay.setRows(40);
        this.Projetdisplay.setAutoscrolls(true);

        this.add(infoProjet);
        this.add(this.Projetdisplay);

        this.LoadMyModel();
    }

    private void LoadMyModel() {
        // update of JLabel representing the Project at top of this panel
        this.infoProjet.setText("Offre  sur le Projet :"+this.monObservableProjett.getNom()+" ("+this.monObservableProjett.getMontant()+")");

        //adding projet offers to the text area
        for (Iterator<Offre> it = this.monObservableProjett.iterator(); it.hasNext(); ) {
            Offre offre = it.next();
            this.Projetdisplay.append(offre + "\n");
        }
    }

    @Override
    public void update(Object observable) {
        Offre derniereOffre = null;

        for (Iterator<Offre> it = this.monObservableProjett.iterator(); it.hasNext(); )
            derniereOffre = it.next();
        if (derniereOffre == null)
            throw new NullPointerException();
        else
            this.Projetdisplay.append(derniereOffre + "\n");
    }

    /**
     * Implementing OptimizedClass as my Graphical elements are actualized on my Model notifications
     * need to unregister me from my Observable Model list
     * This is to allow garbage collector freeing my occupied memory space at my instantiation (creation)
     */

    @Override
    public void destroy() {
        this.monObservableProjett.deleteObserver(this);
    }

}
