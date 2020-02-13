package fr.cnam.revision.application;

import fr.cnam.revision.plateforme.Projet;
import fr.cnam.revision.plateforme.ProjetConcret;
import fr.cnam.tp13.application.TchatGui;

import javax.swing.*;

public class OffreSwing {
    final private Projet projet;
    //TODO MAnage JFrame Closer to unregister from ObservableProjet
    final JFrame fenetre;
    //TODO Moove to controller JPanel
    final private JTextField valeurMontant = new JTextField(6);
    //TODO Moove to controller JPanel
    final private JTextField valeurTaux = new JTextField(6);
    //TODO Moove to controller JPanel
    final private JButton boutonAnnuler = new JButton("Annuler");
    //TODO Moove to controller JPanel
    final private JButton boutonPreter = new JButton("Prêter");
    //TODO Moved to ProjectDisplay JPanel final private JTextArea offres = new JTextArea();

    public OffreSwing(Projet projet) {
        this.projet = projet;
        this.fenetre = new JFrame("Offre de prêt");
        offres.setEditable(false);

        fenetre.pack();
        fenetre.setVisible(true);
    }
    private void start() {
        fenetre.pack();
        fenetre.setVisible(true);
    }
    //To Clean and use thread invoker.
    public static void main(String args[]){
        SwingUtilities.invokeLater(() ->new OffreSwing(new ObservableProjet(new ProjetConcret("XYZ",15000))).start());

    }


}
