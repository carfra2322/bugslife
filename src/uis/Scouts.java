package uis;





public class Scouts extends Ant {


    int foodProbability;



    //-------------------------------------------------------------------------
    //	Constructors
    //-------------------------------------------------------------------------

    public Scouts(EnvironmentNode envNode) {

        super(envNode);
        foodProbability = 100;


    }

    //-------------------------------------------------------------------------
    //	Methods
    //-------------------------------------------------------------------------



    public void attack(){

    };



    public void move()
    {


        ArrayList neighbors = currentLocation.getEnvironment().getNeighborNodes(currentLocation);

        int size = MainDriver.rand.nextInt(neighbors.size());

        currentLocation.removeAnt(this);
        currentLocation = (EnvironmentNode ) neighbors.get(size);

        currentLocation.addAnt(this);



        if(currentLocation.isVisible()==false){
            //currentLocation.showNode();
            //Food probability
            int probDriver = MainDriver.rand.nextInt(100);
            if(probDriver<=25){
                //amount of food
                int probFood = MainDriver.rand.nextInt(2);
                if(probFood==0){
                    currentLocation.setFoodAmount(500);
                }
                else{
                    currentLocation.setFoodAmount(1000);
                }
            }

        }


    };
}
