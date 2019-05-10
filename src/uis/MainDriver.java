package uis;
import java.util.Random;

public class MainDriver {
    public static Random rand;
    public static Thread myThread;

    public static void main(String[] args) {
	// write your code here

        AntSimGUI gui = new AntSimGUI();
        SimulationManager SimMan = new SimulationManager(gui);
        rand = new Random();
        myThread = new Thread();



    }
}
