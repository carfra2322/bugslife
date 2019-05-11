package uis;

public class Soldier extends Ant {


    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

    boolean scoutMode;


    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Soldier(EnvironmentNode envNode) {

        super(envNode);
        scoutMode = true;
    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void checkForBala(){

    };

    public void attack(){

    };

    public void move()
    {
        if(scoutMode)
        {
            ArrayList neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);
            int rand = MainDriver.rand.nextInt(neighbors.size());

            //Iterate through the neighbor nodes
            boolean iteratorFoundBala = false;
            for(int i=0; i<neighbors.size(); i++)
            {
                //Check if the neighboring nodes have Bala ants
                if(((EnvironmentNode) neighbors.get(i)).hasBala){
                    currentLocation.removeAnt(this);
                    currentLocation = ((EnvironmentNode) neighbors.get(i));
                    currentLocation.addAnt(this);
                    iteratorFoundBala = true;
                    break;
                }

            }
            //If we iterated through the whole neighbor list and did not find a bala get random location
            if(!iteratorFoundBala)
            {

                currentLocation.removeAnt(this);
                currentLocation = (EnvironmentNode) neighbors.get(rand);
                currentLocation.addAnt(this);
            }
        }

    };
}
