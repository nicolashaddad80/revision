package fr.cnam.revision.application;


import fr.cnam.revision.plateforme.Offre;
import fr.cnam.tp12.mypatterns.MyObserver;

import javax.swing.*;
import java.util.Iterator;


public class ProjetDisplay extends JPanel implements MyObserver {


    //ToClean by using Singleton ???
    private ObservableProjet myObservableProject;

    /**
     * My Model is
     * a simple Counter use simple swing label to show it in the screen
     */
    private JTextArea Projetdisplay;

    /**
     * Constructor
     *
     * @param a_myModel: A Ordered Set
     */
    public ProjetDisplay(ObservableProjet a_myModel) {
        this.myObservableProject = a_myModel;
        this.myObservableProject.addObserver(this);

        this.Projetdisplay = new JTextArea();
        this.Projetdisplay.setLineWrap(true);
        this.Projetdisplay.setWrapStyleWord(true);
        this.Projetdisplay.setEditable(false);
        this.Projetdisplay.setColumns(45);
        this.Projetdisplay.setRows(40);
        this.Projetdisplay.setAutoscrolls(true);

        this.add(this.Projetdisplay);

        this.LoadMyModel();
    }

    private void LoadMyModel() {
        //TODO Add update of JLabel representing the Project at top of this pannel
        for (Iterator<Offre> it = this.myObservableProject.iterator(); it.hasNext(); ) {
            Offre offre = it.next();
            this.Projetdisplay.append(offre + "\n");
        }
    }

    @Override
    public void update(Object observable) {
        Offre derniereOffre = null;

        for (Iterator<Offre> it = this.myObservableProject.iterator(); it.hasNext(); )
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
        this.myObservableProject.deleteObserver(this);
    }

}
