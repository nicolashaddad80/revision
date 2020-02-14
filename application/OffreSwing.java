package fr.cnam.revision.application;

import fr.cnam.revision.applicationProjet.AppProjet;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OffreSwing {

    //TODO MAnage JFrame Closer to unregister from ObservableProjet
    final JFrame fenetre;
    private final ProjetDisplay monAffichageProjet;

    //TODO Moove to controller JPanel
    // final private JTextField valeurMontant = new JTextField(6);
    //TODO Moove to controller JPanel
    // final private JTextField valeurTaux = new JTextField(6);
    //TODO Moove to controller JPanel
    // final private JButton boutonAnnuler = new JButton("Annuler");
    //TODO Moove to controller JPanel
    //final private JButton boutonPreter = new JButton("Prêter");
    //TODO Moved to ProjectDisplay JPanel final private JTextArea offres = new JTextArea();


    public OffreSwing() {

        this.monAffichageProjet = new ProjetDisplay();

        this.fenetre = new JFrame("Offre de prêt");
        //TODO Moved to ProjectDisplay JPanel final private offres.setEditable(false);

        this.fenetre.add(monAffichageProjet);
    }

    public void start() {
        this.fenetre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                myExit();
            }
        });
        this.fenetre.setSize(500, 400);
        this.fenetre.setVisible(true);
    }

    private void myExit() {
        this.monAffichageProjet.destroy();
        System.out.println("Thank you Using this Application");
        this.fenetre.dispose();
        if (AppProjet.getMonObservableProjet().countObservers() == 0)
            System.exit(0);
    }


}
