package fr.cnam.revision.application;


import fr.cnam.tp12.mypatterns.OptimizedClass;


import javax.swing.*;


public class ProjetDisplay extends JPanel implements OptimizedClass {

    /*Attributes*/


    /*Vue Model*/

    /**
     * My Model is a simple Ob
     * servable counter that I will Observe by registering me to him
     */
    //ToClean by using Singleton ???
    private ObservableProjet myObservableProject;
    //private MyObserver myModelObserver;

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

      //  for (String message : this.myObservableProject) this.Projetdisplay.append(message);
    }

    @Override
    public void update(Object observable) {
        //this.Projetdisplay.append(this.myObservableProject.last());
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
