package fr.cnam.revision.projetgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.Date;

public class ControllerProjet extends JPanel {


    private final JTextField valeurMontant = new JTextField(6);
    private final JLabel labelMontant = new JLabel("Montant:");
    private final JPanel panelMontant = new JPanel();

    private final JLabel labelTaux = new JLabel("Taux:");
    private final JTextField valeurTaux = new JTextField(6);
    private final JPanel panelTaux = new JPanel();

    private final JPanel panelBouton = new JPanel();
    private final JButton boutonAnnuler = new JButton("Annuler");
    private final JButton boutonPreter = new JButton("Preter");


    public ControllerProjet() {

        this.panelMontant.add(this.labelMontant,BorderLayout.EAST);
        this.panelMontant.add(this.valeurMontant,BorderLayout.WEST);


        this.panelTaux.add(this.labelTaux,BorderLayout.EAST);
        this.panelTaux.add(this.valeurTaux,BorderLayout.WEST);

        this.panelBouton.add(this.boutonAnnuler,BorderLayout.WEST);
        this.panelBouton.add(this.boutonPreter,BorderLayout.EAST);
        LayoutManager controllerLayout=new GridLayout(3,1);
        this.setLayout(controllerLayout);
        this.add(this.panelMontant,0);
        this.add(this.panelTaux,1);
        this.add(this.panelBouton,2);

        this.boutonPreter.addActionListener(this::updateModel);
        this.boutonAnnuler.addActionListener(this::cancelOffer);



    }

    private void updateModel(ActionEvent actionEvent) {

        //Date object
        Date date = new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        /*TODO incomment if (!userMessageField.getText().isEmpty()) {
            //TODO AppProjet.getMonObservableProjet().add(ts + "  " + this.userLabel.getText() + this.userMessageField.getText() + DebugOnOFF.newline);
            //AppProjet.getMonObservableProjet().faireOffre(this.);
            this.userMessageField.setText("");
        }

         */
        this.clearOffer();
    }

    private void cancelOffer(ActionEvent actionEvent) {
        this.clearOffer();
    }

    private void clearOffer() {
        this.valeurMontant.setText(null);
        this.valeurTaux.setText(null);
    }
}
