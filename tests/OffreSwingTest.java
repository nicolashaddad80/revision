package fr.cnam.revision.tests;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.revision.application.ObservableProjet;
import fr.cnam.revision.application.OffreSwing;
import fr.cnam.revision.applicationProjet.AppProjet;
import fr.cnam.revision.applicationProjet.ProjetConcret;

import javax.swing.*;

public class OffreSwingTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OffreSwing().start());
        /*Launching Additional Views of same Model counter for debug purpose if DEBUG_ON seated to true*/
        if (DebugOnOFF.DEBUG_ON) for (int i = 0; i < DebugOnOFF.NB_DEBUG_PARALLEL_ADDITIONAL_VIEWS; i++)
            SwingUtilities.invokeLater(() -> new OffreSwing().start());
    }
}
