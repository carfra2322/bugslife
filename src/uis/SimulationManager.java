package uis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;



public class SimulationManager implements SimulationEventListener, ActionListener{

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

    private int turns;
    private int days;
    private int years;
    private AntSimGUI gui;
    private Timer swingTimer;
    private int phermone;
    Environment myEnv;


    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public SimulationManager(AntSimGUI gui)
    {
        this.gui = gui;
        this.turns = 0;
        this.phermone = 10;
        this.days = 0;
        this.years = 0;

        //Initialize a Colony View variable
        //ColonyView myColony = new ColonyView(27,27);
        myEnv = new Environment(27,27);

        gui.addSimulationEventListener(this);

        //Initialize the GUI for your Colony View
        gui.initGUI(myEnv);


        //Initialize Environment and pass your colony variable to update it with nodes
        //myEnv = new Environment(myColony);
        //myEnv.startSim();


    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------


    /**
     *	Will be the trigger for all of the ant's actions
     */
    @Override
    public void actionPerformed(ActionEvent arg0)
    {



        gui.setTime("Turn: " + turns++);
        days = turns/10;
        gui.setDays("Days: " + days);

        years = (days/365);
        gui.setYears("Years: " + years);
        myEnv.turnUpdate();

        //If Queen life span is past then queen dies
        if(myEnv.myQueenNode.myQueen.getAlive()==false){
            simulationOver();
        }
        if(days%10==0){
            System.out.println("-====================================");
        }

    }


    public void simulationOver(){
        System.out.println("Life is over Queen");
        JOptionPane.showMessageDialog(null, "The Queen is dead ! Sorry ", " X_X ", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }

    @Override
    public void simulationEventOccurred(SimulationEvent simEvent) {
        if (simEvent.getEventType() == SimulationEvent.NORMAL_SETUP_EVENT)
        {
            // set up initial state of the simulation
            //JOptionPane.showMessageDialog(null, "Normal Setup Event", "Normal Setup", JOptionPane.INFORMATION_MESSAGE);
            myEnv.startSim();

        }
        else if (simEvent.getEventType() == SimulationEvent.QUEEN_TEST_EVENT)
        {
            // set up antSim.simulation for testing the queen ant
            JOptionPane.showMessageDialog(null, "Queen Test Event", "Queen Test", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (simEvent.getEventType() == SimulationEvent.SCOUT_TEST_EVENT)
        {
            // set up antSim.simulation for testing the scout ant
            JOptionPane.showMessageDialog(null, "Scout Test Event", "Scout Test", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (simEvent.getEventType() == SimulationEvent.FORAGER_TEST_EVENT)
        {
            // set up antSim.simulation for testing the forager ant
            JOptionPane.showMessageDialog(null, "Forager Test Event", "Forager Test", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (simEvent.getEventType() == SimulationEvent.SOLDIER_TEST_EVENT)
        {
            // set up antSim.simulation for testing the soldier ant
            JOptionPane.showMessageDialog(null, "Soldier Test Event", "Soldier Test", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (simEvent.getEventType() == SimulationEvent.RUN_EVENT)
        {
            swingTimer = new Timer(1000, this);
            swingTimer.start();

        }
        else if (simEvent.getEventType() == SimulationEvent.STEP_EVENT)
        {
            gui.setTime("Turn: " + turns++);

        }
        else{
            System.out.println("invalid");
        }


    }
}