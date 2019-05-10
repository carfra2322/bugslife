package uis;

public class Foragers extends Ant {

    //-------------------------------------------------------------------------
    //	Attributes
    //-------------------------------------------------------------------------

   boolean forageMode;
   boolean hasFood;
   LinkedStack movementHistory;
   ColonyNodeView lastLocation;
   ArrayList neighbors;


    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Foragers(EnvironmentNode envNode) {
        super(envNode);
        lastLocation = currentLocation.environment.myQueenNode;

        movementHistory = new LinkedStack();
        //All ants must come back to the queen node where they originated from
        movementHistory.add(currentLocation.environment.myQueenNode);
        forageMode = true;
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void move()
    {
        neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);
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
        //We want to validate the neighbor node with the highest phermone amount
        // Change will monitor if there is actually a difference between all neighbors
        int change = 0;

        for(int i=0; i<size; i++){
            int newTemp = ((EnvironmentNode) neighbors.get(i)).getPhermoneAmount();
            if(newTemp>temp){
                highest = newTemp;
                change++;
            }
            temp=newTemp;
        }
        /**
         * FORAGE MODE
         * */
        if(this.forageMode) {
            //if phermone levels are the same then randomly move
            if (change == 0) {
                System.out.println("NO CHANGEEEEEE ==========================================================>");
                int neighborsize = MainDriver.rand.nextInt(neighbors.size());
                currentLocation.removeAnt(this);
                currentLocation = (EnvironmentNode) neighbors.get(neighborsize);
                currentLocation.addAnt(this);
                //Add movement node to movement history
                movementHistory.add(currentLocation);

            }
            //if there is a difference in the phermone levels then pick the highest phermone level node
            if (change > 0) {
                EnvironmentNode newLocation = ((EnvironmentNode) neighbors.get(highest));
                currentLocation.removeAnt(this);
                //Move to new location
                if (newLocation.getID() != lastLocation.getID()) {
                    currentLocation = newLocation;
                } else {
                    currentLocation = ((EnvironmentNode) neighbors.get(highest - 1));
                }
                ;

                currentLocation.addAnt(this);
                movementHistory.add(currentLocation);

            }
            /**
             * FORAGE MODE ENDS
             * RETURN TO NEST MODE BEGINS
             * */
            if(!this.forageMode){

                System.out.println("=====================================================RETURN TO NEST MODE ON ");
                //Checks if it is queen node
                if(currentLocation.getHasQueen()==false) {
                    currentLocation.removeAnt(this);
                    //removes last history node which is where we are
                    movementHistory.pop();
                    //sets current location to the past history node before the current one
                    currentLocation = (EnvironmentNode) movementHistory.pop();
                    currentLocation.addAnt(this);
                }
                //if it is a queen node
                //Then drop the food and go back to forage mode
                else{
                    currentLocation.setFoodAmount((currentLocation.getFoodAmount())+1);
                    setForageMode(true);
                }
            }
        }

    }

    public LinkedStack getMovementHistory() {
        return movementHistory;
    }

    public void setMovementHistory(LinkedStack movementHistory) {
        this.movementHistory = movementHistory;
    }

    public void pickUpFood(){};

    public void setFoodSupply()
    {

    };


    public void checkPhermone(){};

    public void setPhermone(){};

    public void setMoveHistory(){};

    public void clearMoveHistory(){};

    public boolean getForageMode() {
        return forageMode;
    }

    public void setForageMode(boolean forageMode) {
        this.forageMode = forageMode;
    }
}
