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
   int sameSpot;
   int countFood;


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
        sameSpot = 0;
        countFood = 0;
    }


    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------

    public void move()
    {
        if((currentLocation.hasQueen)){
            forageMode=true;
            movementHistory.clear();
            lastLocation = currentLocation.environment.myQueenNode;
        }
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
        if(currentLocation.ID.compareTo(lastLocation.ID)==0){
            sameSpot++;
        }

        if(sameSpot>2){
            currentLocation.removeAnt(this);
            currentLocation = (EnvironmentNode) neighbors.get(MainDriver.rand.nextInt(neighbors.size()));
            currentLocation.addAnt(this);
            movementHistory.add(currentLocation);
        }

        //We want to validate the neighbor node with the highest phermone amount
        // Change will monitor if there is actually a difference between all neighbors
        boolean change = false;

        for(int i=0; i<neighbors.size(); i++){
            int newTemp = ((EnvironmentNode) neighbors.get(i)).getPhermoneAmount();
            if(newTemp>temp){
                highest = newTemp;
                change=true;
            }
            temp=newTemp;
        }
        /**
         * FORAGE MODE
         * */
        if(forageMode) {
            //if phermone levels are the same then randomly move
            if (!change) {

                int neighborsize = MainDriver.rand.nextInt(neighbors.size());
                currentLocation.removeAnt(this);
                lastLocation = currentLocation;
                currentLocation = (EnvironmentNode) neighbors.get(neighborsize);
                currentLocation.addAnt(this);
                //Add movement node to movement history
                movementHistory.add(currentLocation);

            }
            //if there is a difference in the phermone levels then pick the highest phermone level node
            else if (change) {
                EnvironmentNode newLocation = ((EnvironmentNode) neighbors.get(highest));
                currentLocation.removeAnt(this);
                lastLocation = currentLocation;

                for(int i=neighbors.size(); i>0; i--)
                {
                    if (newLocation.getID() != lastLocation.getID()) {
                        currentLocation = newLocation;
                        break;
                    }
                    else{

                        newLocation = ((EnvironmentNode) neighbors.get(i));


                    }
                }

                currentLocation.addAnt(this);
                movementHistory.add(currentLocation);

            }
        }
        /**
         * FORAGE MODE ENDS
         * RETURN TO NEST MODE BEGINS
         * */

        if(forageMode==false)
        {


            //Checks if it is queen node
            if(currentLocation.getHasQueen()==false)
            {
                if(currentLocation.phermoneAmount < 1000)
                {
                    currentLocation.setPheromoneLevel(currentLocation.getPhermoneAmount() + 10);
                }
                currentLocation.removeAnt(this);
                lastLocation = currentLocation;
                currentLocation = (EnvironmentNode) movementHistory.pop();
                if(currentLocation.foodAmount>0) {
                    countFood = countFood + 1;

                }
                currentLocation.addAnt(this);
            }
            //if it is a queen node
            //Then drop the food and go back to forage mode
            else if(currentLocation.hasQueen==true)
                {

                    currentLocation.environment.myQueenNode.setFoodAmount((currentLocation.getFoodAmount())+countFood);

                    this.setForageMode(true);
                    movementHistory.clear();
                    //movementHistory.add(currentLocation.environment.myQueenNode);
                    sameSpot=0;

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
