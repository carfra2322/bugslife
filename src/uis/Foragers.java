package uis;

public class Foragers extends Ant {

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

   boolean forageMode;
   boolean hasFood;
   ListGraph movementHistory;
   ColonyNodeView lastLocation;
   ArrayList neighbors;


    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Foragers(EnvironmentNode envNode) {
        super(envNode);
        lastLocation = currentLocation.environment.myQueenNode;
        neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void move()
    {

        int size = neighbors.size();
        int temp =0;
        int highest = 0;
        //Delete invisible ones
        for(int i=0; i<size; i++){
            if(((EnvironmentNode) neighbors.get(i)).isVisible()==false){
                neighbors.remove(i);
            }
        }
        size = neighbors.size();
        int change = 0;
        for(int i=0; i<size; i++){
            int newTemp = ((EnvironmentNode) neighbors.get(i)).getPhermoneAmount();
            if(newTemp>temp){
                highest = newTemp;
                change++;
            }
            temp=newTemp;
        }

        //if phermone levels are the same then randomly move
        if(change==0){
            int neighborsize = MainDriver.rand.nextInt(neighbors.size());
            currentLocation.removeAnt(this);
            currentLocation = (EnvironmentNode ) neighbors.get(neighborsize);
            currentLocation.addAnt(this);

        }
        else if(change>0) {
            EnvironmentNode newLocation = ((EnvironmentNode) neighbors.get(highest));
            currentLocation.removeAnt(this);
            //Move to new location
            if(newLocation.getID() != lastLocation.getID())
            {
                currentLocation = newLocation;
            }
            else{
                currentLocation = ((EnvironmentNode) neighbors.get(highest-1));
            };

            currentLocation.addAnt(this);

        }




    }


    public void pickUpFood(){};

    public void setFoodSupply()
    {

    };


    public void checkPhermone(){};

    public void setPhermone(){};

    public void setMoveHistory(){};

    public void clearMoveHistory(){};

}
